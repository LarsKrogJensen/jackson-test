package se.lars;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Outcome {
    public long id;
    public BigDecimal currentOdds;
    public Long labelTranslationKey;
    public String homeScore;
    public String awayScore;
    public Double handicapLine;
    public Boolean isHomeParticipant;
    public Boolean scratched;
    public Boolean nonRunner;
    public Integer startNumber;
    public String distance;
    public Long participantTranslationKey;
    public Long participantId;
    public Long currentPriceModifiedTimeMs;
    public Double scoreLikeliness;
    public List<String> tags;
    public BigDecimal probability;

    public Outcome() {
    }

    public Outcome(@JsonProperty long id,
                   @JsonProperty BigDecimal currentOdds,
                   @JsonProperty Long labelTranslationKey,
                   @JsonProperty String homeScore,
                   @JsonProperty String awayScore,
                   @JsonProperty Double handicapLine,
                   @JsonProperty Boolean isHomeParticipant,
                   @JsonProperty Boolean scratched,
                   @JsonProperty Boolean nonRunner,
                   @JsonProperty Integer startNumber,
                   @JsonProperty String distance,
                   @JsonProperty Long participantTranslationKey,
                   @JsonProperty Long participantId,
                   @JsonProperty Long currentPriceModifiedTimeMs,
                   @JsonProperty Double scoreLikeliness,
                   @JsonProperty List<String> tags,
                   @JsonProperty BigDecimal probability) {
        this.id = id;
        this.currentOdds = currentOdds;
        this.labelTranslationKey = labelTranslationKey;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.handicapLine = handicapLine;
        this.isHomeParticipant = isHomeParticipant;
        this.scratched = scratched;
        this.nonRunner = nonRunner;
        this.startNumber = startNumber;
        this.distance = distance;
        this.participantTranslationKey = participantTranslationKey;
        this.participantId = participantId;
        this.currentPriceModifiedTimeMs = currentPriceModifiedTimeMs;
        this.scoreLikeliness = scoreLikeliness;
        this.tags = tags;
        this.probability = probability;
    }

    static Outcome create(int seed) {
        Outcome o = new Outcome();
        o.id = seed;
        o.currentOdds = new BigDecimal(seed);
        o.homeScore = Integer.toString(seed);
        o.awayScore = Integer.toString(seed);
        o.handicapLine = (double) seed;
        o.isHomeParticipant = seed % 4 == 0;
        o.labelTranslationKey = (long) seed;
        o.scratched = seed % 4 == 0;
        o.nonRunner = seed % 4 == 0;
        o.startNumber = seed;
        o.distance = Integer.toString(seed);
        o.participantTranslationKey = (long) seed;
        o.participantId = (long) seed;
        o.currentPriceModifiedTimeMs = (long) seed;
        o.scoreLikeliness = (double) seed;
        o.tags = Arrays.asList("tag1", "tag2", "tag3");
        o.probability = new BigDecimal(seed);
        return o;

    }
    public void writeJson(JsonGenerator out) throws IOException {
        out.writeStartObject();
        out.writeNumberField("id", id);
        if (currentOdds != null) {
            out.writeNumberField("currentOdds", currentOdds);
        }
        if (labelTranslationKey != null) {
            out.writeNumberField("labelTranslationKey", labelTranslationKey);
        }
        if (homeScore != null) {
            out.writeStringField("homeScore", homeScore);
        }
        if (awayScore != null) {
            out.writeStringField("awayScore", awayScore);
        }
        if (handicapLine != null) {
            out.writeNumberField("handicapLine", handicapLine);
        }
        if (isHomeParticipant != null) {
            out.writeBooleanField("isHomeParticipant", isHomeParticipant);
        }
        if (scratched != null) {
            out.writeBooleanField("scratched", scratched);
        }
        if (nonRunner != null) {
            out.writeBooleanField("nonRunner", nonRunner);
        }
        if (startNumber != null) {
            out.writeNumberField("startNumber", startNumber);
        }
        if (distance != null) {
            out.writeStringField("distance", distance);
        }
        if (participantTranslationKey != null) {
            out.writeNumberField("participantTranslationKey", participantTranslationKey);
        }
        if (participantId != null) {
            out.writeNumberField("participantId", participantId);
        }
        if (currentPriceModifiedTimeMs != null) {
            out.writeNumberField("currentPriceModifiedTimeMs", currentPriceModifiedTimeMs);
        }
        if (scoreLikeliness != null) {
            out.writeNumberField("scoreLikeliness", scoreLikeliness);
        }
        if (tags != null) {
            out.writeArrayFieldStart("tags");
            for (String tag : tags) {
                out.writeString(tag);
            }
            out.writeEndArray();
        }
        if (probability != null) {
            out.writeNumberField("probability", probability);
        }
        out.writeEndObject();
    }
}
