package org.almatrasporti.common.services.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.almatrasporti.common.models.CANBusMessage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class BatchCANBusMessageSerializer extends StdSerializer<CANBusMessage> {

    public BatchCANBusMessageSerializer() {
        this(null);
    }

    public BatchCANBusMessageSerializer(Class<CANBusMessage> t) {
        super(t);
    }

    @Override
    public void serialize(CANBusMessage message, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("VinVehicle", message.getVin());
        jsonGenerator.writeNumberField("Timestamp", message.getTimestamp());
        jsonGenerator.writeStringField("MessageDate", LocalDateTime.ofEpochSecond(message.getTimestamp(), 0, ZoneOffset.UTC).toString());
        jsonGenerator.writeStringField("Driver", message.getDriver());
        jsonGenerator.writeNumberField("Odometer", message.getOdometer());
        jsonGenerator.writeNumberField("LifeConsumption", message.getLifeConsumption());
        jsonGenerator.writeObjectFieldStart("Position");
            jsonGenerator.writeNumberField("lon", message.getLon());
            jsonGenerator.writeNumberField("lat", message.getLat());
            jsonGenerator.writeNumberField("lat", message.getLat());
            jsonGenerator.writeNumberField("altitude", message.getAltitude());
            jsonGenerator.writeNumberField("heading", message.getHeading());
            jsonGenerator.writeNumberField("speed", message.getSpeed());
            jsonGenerator.writeNumberField("satellites", message.getSatellites());
        jsonGenerator.writeEndObject();
        jsonGenerator.writeEndObject();
    }
}
