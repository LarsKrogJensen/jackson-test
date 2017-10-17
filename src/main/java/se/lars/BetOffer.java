package se.lars;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BetOffer {
    public long id;
    public Long criterionId;
    public Long criterionTranslationKey;
    public Boolean criterionIsDefault;
    public Integer criterionNumber;
    public Integer secondCriterionNumber;
    public Integer thirdCriterionNumber;
    public Long extraInfoTranslationKey;
    public Long openingTimeMs;
    public Integer closingTimeOffsetMinutes;
    public Long fixedClosingTimeMs;
    public Long settledTimeMs;
    public Long suspendedTimeMs;
    public Long discardedTimeMs;
    public Integer toBePlaced;
    public Boolean startingPrice;
    public List<Outcome> outcomes;
    public Boolean applyRule4;
    public Boolean pbaDisabled;
    public Boolean combinable;
    public boolean offeredLive;
    public Long eventId;
    public Long version;
    public Long offeringToolVersion;
    public Boolean onSite;
    public List<String> tags;
    public Integer from;
    public Integer to;
    public Long descriptionTextId;
    public List<String> descriptionArguments;
    public boolean offeredPrematch;
    public List<String> criterionArguments;
    public BigDecimal cashOutPayback;
    public Long trackingTimeMs;

    public BetOffer() {
    }

    public BetOffer(@JsonProperty long id,
                    @JsonProperty Long criterionId,
                    @JsonProperty Long criterionTranslationKey,
                    @JsonProperty Boolean criterionIsDefault,
                    @JsonProperty Integer criterionNumber,
                    @JsonProperty Integer secondCriterionNumber,
                    @JsonProperty Integer thirdCriterionNumber,
                    @JsonProperty Long extraInfoTranslationKey,
                    @JsonProperty Long openingTimeMs,
                    @JsonProperty Integer closingTimeOffsetMinutes,
                    @JsonProperty Long fixedClosingTimeMs,
                    @JsonProperty Long settledTimeMs,
                    @JsonProperty Long suspendedTimeMs,
                    @JsonProperty Long discardedTimeMs,
                    @JsonProperty Integer toBePlaced,
                    @JsonProperty Boolean startingPrice,
                    @JsonProperty List<Outcome> outcomes,
                    @JsonProperty Boolean applyRule4,
                    @JsonProperty Boolean pbaDisabled,
                    @JsonProperty Boolean combinable,
                    @JsonProperty boolean offeredLive,
                    @JsonProperty Long eventId,
                    @JsonProperty Long version,
                    @JsonProperty Long offeringToolVersion,
                    @JsonProperty Boolean onSite,
                    @JsonProperty List<String> tags,
                    @JsonProperty Integer from,
                    @JsonProperty Integer to,
                    @JsonProperty Long descriptionTextId,
                    @JsonProperty List<String> descriptionArguments,
                    @JsonProperty boolean offeredPrematch,
                    @JsonProperty List<String> criterionArguments,
                    @JsonProperty BigDecimal cashOutPayback,
                    @JsonProperty Long trackingTimeMs) {
        this.id = id;
        this.criterionId = criterionId;
        this.criterionTranslationKey = criterionTranslationKey;
        this.criterionIsDefault = criterionIsDefault;
        this.criterionNumber = criterionNumber;
        this.secondCriterionNumber = secondCriterionNumber;
        this.thirdCriterionNumber = thirdCriterionNumber;
        this.extraInfoTranslationKey = extraInfoTranslationKey;
        this.openingTimeMs = openingTimeMs;
        this.closingTimeOffsetMinutes = closingTimeOffsetMinutes;
        this.fixedClosingTimeMs = fixedClosingTimeMs;
        this.settledTimeMs = settledTimeMs;
        this.suspendedTimeMs = suspendedTimeMs;
        this.discardedTimeMs = discardedTimeMs;
        this.toBePlaced = toBePlaced;
        this.startingPrice = startingPrice;
        this.outcomes = outcomes;
        this.applyRule4 = applyRule4;
        this.pbaDisabled = pbaDisabled;
        this.combinable = combinable;
        this.offeredLive = offeredLive;
        this.eventId = eventId;
        this.version = version;
        this.offeringToolVersion = offeringToolVersion;
        this.onSite = onSite;
        this.tags = tags;
        this.from = from;
        this.to = to;
        this.descriptionTextId = descriptionTextId;
        this.descriptionArguments = descriptionArguments;
        this.offeredPrematch = offeredPrematch;
        this.criterionArguments = criterionArguments;
        this.cashOutPayback = cashOutPayback;
        this.trackingTimeMs = trackingTimeMs;
    }

    public static BetOffer createBetOffer(int seed) {
        BetOffer bo = new BetOffer();
        bo.id = seed;
        bo.criterionId = (long) seed;
        bo.criterionTranslationKey = (long) seed;
        bo.criterionIsDefault = seed % 2 == 0;
        bo.criterionNumber = seed;
        bo.thirdCriterionNumber = seed;
        bo.extraInfoTranslationKey = (long) seed;
        bo.openingTimeMs = (long) seed;
        bo.secondCriterionNumber = seed;
        bo.closingTimeOffsetMinutes = seed;
        bo.fixedClosingTimeMs = (long) seed;
        bo.settledTimeMs = (long) seed;
        bo.suspendedTimeMs = (long) seed;
        bo.discardedTimeMs = (long) seed;
        bo.toBePlaced = seed;
        bo.startingPrice = seed % 2 == 0;
        bo.applyRule4 = seed % 2 == 0;
        bo.pbaDisabled = seed % 2 == 0;
        bo.combinable = seed % 2 == 0;
        bo.offeredLive = seed % 2 == 0;
        bo.eventId = seed * 2L;
        bo.version = (long) seed;
        bo.offeringToolVersion = (long) seed;
        bo.onSite = seed % 2 == 0;
        bo.tags = Arrays.asList("tag1", "tag2", "tag3");
        bo.from = seed;
        bo.to = seed;
        bo.descriptionTextId = (long) seed;
        bo.descriptionArguments = new ArrayList<>();
        bo.offeredPrematch = seed % 3 == 0;
        bo.criterionArguments = new ArrayList<>();
        bo.cashOutPayback = new BigDecimal(seed);
        bo.trackingTimeMs = (long) seed;
        bo.outcomes = IntStream.of(1, 2, 3, 4, 5).boxed().map(operand -> Outcome.create(seed * operand)).collect(Collectors.toList());

        return bo;
    }

    public void writeJson(JsonGenerator out) throws IOException {
        out.writeStartObject();
        out.writeNumberField("id", id);
         if (criterionId != null) {
             out.writeNumberField("criterionId", criterionId);
         }
         if (criterionTranslationKey != null) {
             out.writeNumberField("criterionTranslationKey",criterionTranslationKey);
         }
         if (criterionIsDefault != null) {
             out.writeBooleanField("criterionIsDefault", criterionIsDefault);
         }
         if (criterionNumber != null) {
             out.writeNumberField("criterionNumber", criterionNumber);
         }
         if (secondCriterionNumber != null) {
             out.writeNumberField("secondCriterionNumber",secondCriterionNumber);
         }
         if (thirdCriterionNumber != null) {
             out.writeNumberField("thirdCriterionNumber", thirdCriterionNumber);
         }
         if (extraInfoTranslationKey != null) {
             out.writeNumberField("extraInfoTranslationKey", extraInfoTranslationKey);
         }
         if (openingTimeMs != null) {
             out.writeNumberField("openingTimeMs",openingTimeMs);
         }
         if (closingTimeOffsetMinutes != null) {
             out.writeNumberField("closingTimeOffsetMinutes", closingTimeOffsetMinutes);
         }
         if (fixedClosingTimeMs != null) {
             out.writeNumberField("fixedClosingTimeMs", fixedClosingTimeMs);
         }
         if (settledTimeMs != null) {
             out.writeNumberField("settledTimeMs", settledTimeMs);
         }
         if (suspendedTimeMs != null) {
             out.writeNumberField("suspendedTimeMs", suspendedTimeMs);
         }
         if (discardedTimeMs != null) {
             out.writeNumberField("discardedTimeMs", discardedTimeMs);
         }
         if (toBePlaced != null) {
             out.writeNumberField("toBePlaced", toBePlaced);
         }
         if (startingPrice != null) {
             out.writeBooleanField("startingPrice", startingPrice);
         }

         out.writeArrayFieldStart("outcomes");
         if (outcomes != null) {
             for (Outcome outcome : outcomes) {
                 outcome.writeJson(out);
             }
         }
         out.writeEndArray();

         if (applyRule4 != null) {
             out.writeBooleanField("applyRule4", applyRule4);
         }
         if (pbaDisabled != null) {
             out.writeBooleanField("pbaDisabled", pbaDisabled);
         }
         if (combinable != null) {
             out.writeBooleanField("combinable", combinable);
         }
         out.writeBooleanField("offeredLive", offeredLive);
         if (eventId != null) {
             out.writeNumberField("eventId", eventId);
         }
         if (version != null) {
             out.writeNumberField("version", version);
         }
         if (offeringToolVersion != null) {
             out.writeNumberField("offeringToolVersion", offeringToolVersion);
         }
         if (onSite != null) {
             out.writeBooleanField("onSite", onSite);
         }
         if (tags != null) {
             out.writeArrayFieldStart("tags");
             for (String tag : tags) {
                 out.writeString(tag);
             }
             out.writeEndArray();
         }
         if (from != null) {
             out.writeNumberField("from", from);
         }
         if (to != null) {
             out.writeNumberField("to",to);
         }
         if (descriptionTextId != null) {
             out.writeNumberField("descriptionTextId", descriptionTextId);
         }
         if (descriptionArguments != null) {
             out.writeArrayFieldStart("descriptionArguments");
             for (String argument : descriptionArguments) {
                 out.writeString(argument);
             }
             out.writeEndArray();
         }
         out.writeBooleanField("offeredPrematch", offeredPrematch);
         if (criterionArguments != null) {
             out.writeArrayFieldStart("criterionArguments");
             for (String argument : criterionArguments) {
                 out.writeString(argument);
             }
             out.writeEndArray();
         }
         if (cashOutPayback != null) {
             out.writeNumberField("cashOutPayback", cashOutPayback);
         }
         if (trackingTimeMs != null) {
             out.writeNumberField("trackingTimeMs", trackingTimeMs);
         }
         out.writeEndObject();
    }
}
