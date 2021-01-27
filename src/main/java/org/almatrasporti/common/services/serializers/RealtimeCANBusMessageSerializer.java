package org.almatrasporti.common.services.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.almatrasporti.common.models.CANBusMessage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class RealtimeCANBusMessageSerializer extends StdSerializer<CANBusMessage> {

    public RealtimeCANBusMessageSerializer() {
        this(null);
    }

    public RealtimeCANBusMessageSerializer(Class<CANBusMessage> t) {
        super(t);
    }

    @Override
    public void serialize(CANBusMessage message, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("Timestamp", message.getTimestamp());
        jsonGenerator.writeStringField("VinVehicle", message.getVin());
        jsonGenerator.writeObjectFieldStart("Position");
            jsonGenerator.writeNumberField("lon", message.getLon());
            jsonGenerator.writeNumberField("lat", message.getLat());
            jsonGenerator.writeNumberField("altitude", message.getAltitude());
            jsonGenerator.writeNumberField("heading", message.getHeading());
            jsonGenerator.writeNumberField("speed", message.getSpeed());
            jsonGenerator.writeNumberField("satellites", message.getSatellites());
        jsonGenerator.writeEndObject();
        jsonGenerator.writeEndObject();
    }
}
