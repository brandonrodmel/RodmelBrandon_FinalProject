package com.example.rodmelbrandon_finalproject.model;

import java.util.Objects;

public class Computer extends Electronic {

    private String mKeyboard;
    private String mMouse;
    private String mChassis;

    public Computer(String name, double price, String gpu, String cpu, int ram, int storage, String keyboard, String mouse, String chassis, int quantity) {
        super(name, price, gpu, cpu, ram, storage);
        mKeyboard = keyboard;
        mMouse = mouse;
        mChassis = chassis;
    }

    public String getKeyboard() {
        return mKeyboard;
    }

    public void setKeyboard(String keyboard) {
        mKeyboard = keyboard;
    }

    public String getMouse() {
        return mMouse;
    }

    public void setMouse(String mouse) {
        mMouse = mouse;
    }

    public String getChassis() {
        return mChassis;
    }

    public void setChassis(String chassis) {
        mChassis = chassis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Computer)) return false;
        if (!super.equals(o)) return false;
        Computer computer = (Computer) o;
        return Objects.equals(mKeyboard, computer.mKeyboard) && Objects.equals(mMouse, computer.mMouse) && Objects.equals(mChassis, computer.mChassis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mKeyboard, mMouse, mChassis);
    }

    @Override
    public String toString() {
        return mName +
                " [Price: " + currency.format(mPrice) +
                ", GPU: " + mGPU +
                ", CPU: " + mCPU +
                ", RAM: " + mRAM +" GB " +
                ", Storage: " + mStorage + " GB" +
                ", Keyboard=" + mKeyboard +
                ", Mouse=" + mMouse +
                ", Chassis= " + mChassis +
                "]";
    }
}
