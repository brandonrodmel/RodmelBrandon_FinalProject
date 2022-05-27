package com.example.rodmelbrandon_finalproject.model;

import java.util.Objects;

public class Console extends Electronic implements Comparable<Electronic> {

    private boolean mDiskDrive;
    private String mColor;

    public Console(String name, double price, String gpu, String cpu, int ram, int storage, int quantity, boolean diskDrive, String color) {
        super(name, price, gpu, cpu, ram, storage);
        mDiskDrive = diskDrive;
        mColor = color;
    }

    public boolean isDiskDrive() {
        return mDiskDrive;
    }

    public void setDiskDrive(boolean diskDrive) {
        mDiskDrive = diskDrive;
    }

    public String getColor() {
        return mColor;
    }

    public void setColor(String color) {
        mColor = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Console)) return false;
        if (!super.equals(o)) return false;
        Console console = (Console) o;
        return mDiskDrive == console.mDiskDrive && Objects.equals(mColor, console.mColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mDiskDrive, mColor);
    }

    @Override
    public String toString() {
        return mName +
                " [Price: " + currency.format(mPrice) +
                ", GPU: " + mGPU +
                ", CPU: " + mCPU +
                ", RAM: " + mRAM +" GB " +
                ", Storage: " + mStorage + " GB" +
                ", Disk Drive=" + mDiskDrive +
                ", Color=" + mColor +
                "]";
    }

    public int compareTo(Console o) {
        if(super.compareTo(o) != 0)  return super.compareTo(o);

        int diskDriveComp = Boolean.compare(mDiskDrive, o.mDiskDrive);
        if(diskDriveComp != 0) return diskDriveComp;

        return mColor.compareTo(o.mColor);
    }
}