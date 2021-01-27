package org.almatrasporti.common.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.almatrasporti.common.models.CANBusMessage;
import org.almatrasporti.common.services.serializers.BatchCANBusMessageSerializer;
import org.almatrasporti.common.services.serializers.RealtimeCANBusMessageSerializer;

public class CANBusMessageFormatter {
    public static String toCSV(CANBusMessage message) {
        return message.getVin() + "," +
                message.getTimestamp() + "," +
                message.getDriver() + "," +
                message.getOdometer() + "," +
                message.getLifeConsumption() + "," +
                message.getLon() + "," +
                message.getLat() + "," +
                message.getAltitude() + "," +
                message.getHeading() + "," +
                message.getSpeed() + "," +
                message.getSatellites();
    }

    public static String toBatchJSON(CANBusMessage message) {
        return CANBusMessageFormatter.toJson(message, new BatchCANBusMessageSerializer());
    }

    public static String toRealtimeJSON(CANBusMessage message) {
        return CANBusMessageFormatter.toJson(message, new RealtimeCANBusMessageSerializer());
    }

    protected static String toJson(CANBusMessage message, StdSerializer<CANBusMessage> serializer) {
        ObjectMapper objectMapper = new ObjectMapper();

        SimpleModule module = new SimpleModule();
        module.addSerializer(CANBusMessage.class, serializer);
        objectMapper.registerModule(module);

        try {
            String result = objectMapper.writeValueAsString(message);
            System.out.println(result);
            return result;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }
}
