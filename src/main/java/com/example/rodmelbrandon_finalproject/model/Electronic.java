package com.example.rodmelbrandon_finalproject.model;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Objects;

public abstract class Electronic implements Serializable, Comparable<Electronic> {

    protected String mName;
    protected double mPrice;
    protected String mGPU;
    protected String mCPU;
    protected int mRAM; //IN GIGABYTES
    protected int mStorage; //IN GIGABYTES

    protected NumberFormat currency = NumberFormat.getCurrencyInstance();

    protected Electronic(String name, double price, String gpu, String cpu, int ram, int storage) {
        mName = name;
        mPrice = price;
        mGPU = gpu;
        mCPU = cpu;
        mRAM = ram;
        mStorage = storage;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public double getPrice() {
        return mPrice;
    }

    public void setPrice(double price) {
        mPrice = price;
    }

    public String getGPU() {
        return mGPU;
    }

    public void setGPU(String GPU) {
        mGPU = GPU;
    }

    public String getCPU() {
        return mCPU;
    }

    public void setCPU(String CPU) {
        mCPU = CPU;
    }

    public int getRAM() {
        return mRAM;
    }

    public void setRAM(int RAM) {
        mRAM = RAM;
    }

    public int getStorage() {
        return mStorage;
    }

    public void setStorage(int storage) {
        mStorage = storage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Electronic)) return false;
        Electronic that = (Electronic) o;
        return Double.compare(that.mPrice, mPrice) == 0 && mRAM == that.mRAM && mStorage == that.mStorage && Objects.equals(mName, that.mName) && Objects.equals(mGPU, that.mGPU) && Objects.equals(mCPU, that.mCPU) && Objects.equals(currency, that.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mName, mPrice, mGPU, mCPU, mRAM, mStorage, currency);
    }

    @Override
    public int compareTo(Electronic o) {
        int nameComp = mName.compareTo(o.mName);
        if(nameComp != 0) return nameComp;

        int priceComp = Double.compare(mPrice, o.mPrice);
        if(priceComp != 0) return priceComp;

        int gpuComp = mGPU.compareTo(o.mGPU);
        if(gpuComp != 0) return gpuComp;

        int cpuComp = mCPU.compareTo(o.mCPU);
        if(cpuComp != 0) return cpuComp;

        int ramComp = Integer.compare(mRAM, o.mRAM);
        if(ramComp != 0) return ramComp;

        return Integer.compare(mStorage, o.mStorage);
    }
}