package se.lars;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.module.afterburner.AfterburnerModule;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.runner.RunnerException;

import java.io.IOException;
import java.io.StringWriter;

public class Main {
    private static int seed;
    private static final JsonFactory jsonFactory = new JsonFactory();
    private static ObjectMapper without = new ObjectMapper();
    private static ObjectMapper with = new ObjectMapper();

    public static void main(String[] args) throws IOException, RunnerException {
        with.registerModule(new AfterburnerModule());
        with.registerModule(new Jdk8Module());
        without.registerModule(new Jdk8Module());

        org.openjdk.jmh.Main.main(args);
//        new Main().withGenerator();
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    public void withoutAfterBurner() throws IOException {
        BetOffer betOffer = BetOffer.createBetOffer(seed++);
        String asString = with.writeValueAsString(betOffer);
        with.readValue(asString, BetOffer.class);

    }


    @Benchmark
    @Fork(value = 1, warmups = 1)
    public void withAfterBurner() throws IOException {
        BetOffer betOffer = BetOffer.createBetOffer(seed++);
        String asString = without.writeValueAsString(betOffer);
        without.readValue(asString, BetOffer.class);
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    public void withGenerator() throws IOException {
        BetOffer betOffer = BetOffer.createBetOffer(seed++);
        StringWriter sw = new StringWriter();
        try (JsonGenerator json = jsonFactory.createGenerator(sw)) {
            betOffer.writeJson(json);
        }
        with.readValue(sw.toString(), BetOffer.class);

    }
}
