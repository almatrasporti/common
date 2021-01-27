package org.almatrasporti.common.models;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.logging.Logger;

public class CANBusMessage {

    @NotEmpty
    @Size(min = 17, max = 17, message = "VIN must be of 17 characters")
    public String vin;

    @NotNull
    @PositiveOrZero
    public Long timestamp;

    @NotEmpty
    public String driver;

    @NotNull
    @PositiveOrZero
    public Long odometer;

    @NotNull
    @PositiveOrZero
    public Long lifeConsumption;

    @NotNull
    public Double lon;

    @NotNull
    public Double lat;

    @NotNull
    public Float altitude;

    @NotNull
    @PositiveOrZero
    public float heading;

    @NotNull
    @PositiveOrZero
    public int speed;

    @NotNull
    @PositiveOrZero
    public int satellites;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public Long getOdometer() {
        return odometer;
    }

    public void setOdometer(Long odometer) {
        this.odometer = odometer;
    }

    public Long getLifeConsumption() {
        return lifeConsumption;
    }

    public void setLifeConsumption(Long lifeConsumption) {
        this.lifeConsumption = lifeConsumption;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Float getAltitude() {
        return altitude;
    }

    public void setAltitude(Float altitude) {
        this.altitude = altitude;
    }

    public float getHeading() {
        return heading;
    }

    public void setHeading(float heading) {
        this.heading = heading;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSatellites() {
        return satellites;
    }

    public void setSatellites(int satellites) {
        this.satellites = satellites;
    }

    public boolean isValid() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<CANBusMessage>> violations = validator.validate(this);

        if (violations.size() > 0) {
            return false;
        }

        return true;
    }
}
