package org.almatrasporti.common.services;

import org.almatrasporti.common.models.CANBusMessage;

import java.util.Arrays;
import java.util.List;

public class CANBusMessageFactory {
    public static CANBusMessage fromCSV(String csv) {
        List<String> pieces = Arrays.asList(csv.split("\\s*,\\s*"));

        CANBusMessage msg = new CANBusMessage();
        msg.setVin(pieces.get(0));
        msg.setTimestamp(Long.parseLong(pieces.get(1)));
        msg.setDriver(pieces.get(2));
        msg.setOdometer(Long.parseLong(pieces.get(3)));
        msg.setLifeConsumption(Long.parseLong(pieces.get(4)));
        msg.setLon(Double.parseDouble(pieces.get(5)));
        msg.setLat(Double.parseDouble(pieces.get(6)));
        msg.setAltitude(Float.parseFloat(pieces.get(7)));
        msg.setHeading(Float.parseFloat(pieces.get(8)));
        msg.setSpeed(Integer.parseInt(pieces.get(9)));
        msg.setSatellites(Integer.parseInt(pieces.get(10)));

        return msg;
    }
}
