package model;

import java.time.LocalTime;

public class Route {
    // Attributes
    private LocalTime start;
    private LocalTime end;
    private String meetingPoint;
    private TypeRoute type;

    /**
     * Creates a new route with the given attributes.
     * 
     * @param startHour    The start hour of the route.
     * @param startMinute  The start minute of the route.
     * @param endHour      The end hour of the route.
     * @param endMinute    The end minute of the route.
     * @param meetingPoint The meeting point of the route.
     * @param type         The type of the route.
     */
    public Route(int startHour, int startMinute, int endHour, int endMinute, String meetingPoint, String type) {
        setStart(startHour, startMinute);
        setEnd(endHour, endMinute);
        this.meetingPoint = meetingPoint;
        setType(type);
    }

    // Getters & Setters
    public LocalTime getStart() {
        return start;
    }

    public void setStart(int hour, int minute) {
        this.start = LocalTime.of(hour, minute);
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(int hour, int minute) {
        this.end = LocalTime.of(hour, minute);
    }

    public String getMeetingPoint() {
        return meetingPoint;
    }

    public void setMeetingPoint(String meetingPoint) {
        this.meetingPoint = meetingPoint;
    }

    public TypeRoute getType() {
        return type;
    }

    public void setType(String type) {
        this.type = TypeRoute.valueOf(type.toUpperCase());
    }

    /**
     * Returns a string representation of the object.
     * 
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        return "¡Excelente! La Ruta de " + type.toString().toLowerCase() + " tiene como punto de encuentro "
                + meetingPoint + " iniciando a las " + start.toString() + ", y termina a las " + end.toString();
    }
}
