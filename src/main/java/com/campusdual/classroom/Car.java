package com.campusdual.classroom;

public class Car {
    public String brand;
    public String model;
    public static final int MAX_SPEED = 120;
    public String fuel;
    public int speedometer;
    public int tachometer;
    public String gear = "N";
    public boolean reverse = false;
    public int wheelsAngle = 0;

    public Car (String brand, String model, String fuel){
        this.brand = brand;
        this.model = model;
        this.fuel = fuel;
    }

    public Car(){
        this.brand = "Citroën";
        this.model = "Xsara";
        this.fuel = "Diesel";
    }

    public void start() {
        if (this.tachometer == 0){
            this.tachometer = 1000;
            System.out.println("Vehículo encendido");
        }else{
            System.out.println("Vehículo ya está encendido");
        }
    }

    public void stop() {
        if (this.speedometer == 0){
            this.tachometer = 0;
            System.out.println("Vehículo apagado");
        }else{
            System.out.println("No se puede apagar el vehículo. Primero tiene que estar detenido");
        }
    }
    public void accelerate(){
        if (this.tachometer == 0){
            System.out.println("No se puede acelerar con el coche apagado.");
            return;
        }
        if (this.reverse){
            System.out.println("No se puede acelerar hacia atrás (quite la marcha atrás).");
            return;
        }
        if (this.speedometer < MAX_SPEED){
            this.speedometer += 10;
            if (this.speedometer > MAX_SPEED) this.speedometer = MAX_SPEED;
            System.out.println("Acelerando. Velocidad actual: " + this.speedometer + " km/h");
        }else{
            System.out.println("No se puede superar la velocidad máxima (" + MAX_SPEED + " km/h).");
        }

    }

    public void brake(){
        if (this.tachometer == 0){
            System.out.println("No se puede frenar con el coche apagado.");
            return;
        }
        if (this.speedometer > 0){
            this.speedometer -= 10;
            if (this.speedometer < 0) this.speedometer = 0;
            System.out.println("Frenando. Velocidad actual: " + this.speedometer + " km/h");
        }else{
            System.out.println("El coche ya está detenido.");
        }


    }

    public void turnAngleOfWheels(int angle){
        if (angle > 45) {
            this.wheelsAngle = 45;
            System.out.println("Se ha limitado el giro a 45° (máximo permitido).");
        } else if (angle < -45) {
            this.wheelsAngle = -45;
            System.out.println("Se ha limitado el giro a -45° (mínimo permitido).");
        } else {
            this.wheelsAngle = angle;
            System.out.println("Volante girado " + angle + "°");
        }

    }

    public String showSteeringWheelDetail(){
        if (this.wheelsAngle == 0) return "Volante recto";
        if (this.wheelsAngle > 0)  return "Volante " + this.wheelsAngle + "° a la derecha";
        return "Volante " + Math.abs(this.wheelsAngle) + "° a la izquierda";

    }

    public boolean isReverse(){
        return this.reverse;


    }

    public void setReverse(boolean reverse){
        if (reverse){
            if (this.tachometer == 0){
                System.out.println("No se puede poner marcha atrás con el coche apagado.");
                return;
            }
            if (this.speedometer != 0){
                System.out.println("No se puede poner marcha atrás mientras el coche está en movimiento.");
                return;
            }
            this.reverse = true;
            this.gear = "R";
            System.out.println("Marcha atrás engranada.");
        }else{
            this.reverse = false;
            this.gear = "N";
            System.out.println("Marcha atrás desengranada.");
        }

    }

    public void showDetails(){
        System.out.println("----- Detalles del vehículo -----");
        System.out.println("Marca/Modelo: " + this.brand + " " + this.model);
        System.out.println("Combustible : " + this.fuel);
        System.out.println("Tacómetro   : " + this.tachometer + " rpm");
        System.out.println("Velocidad   : " + this.speedometer + " km/h");
        System.out.println("Marcha      : " + this.gear + (this.reverse ? " (R activada)" : ""));
        System.out.println("Volante     : " + showSteeringWheelDetail());
        System.out.println("---------------------------------");

    }

    public boolean isTachometerGreaterThanZero() {
        return this.tachometer > 0;

    }

    public boolean isTachometerEqualToZero() {
        return this.tachometer == 0;
    }

    public static void main(String[] args) {
        Car c = new Car("Citroën", "Xsara", "Diésel");
        c.start();
        c.accelerate();
        c.turnAngleOfWheels(20);
        c.brake();
        c.brake();
        c.setReverse(true); // sólo debe dejar si está parado y encendido
        c.showDetails();
        c.stop();

    }


}
