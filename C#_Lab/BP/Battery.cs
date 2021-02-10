enum BatteryType{
    Li_Ion, NiMH, NiCd
}
class Battery{
    public string model;
    public float idle_time, hoursTalk;
    public BatteryType batteryType;
    public Battery(string model, BatteryType batteryType){
        this.model = model; this.batteryType = batteryType;
        idle_time = 0; hoursTalk = 0;
    }
    public Battery(string model, float idle_time, BatteryType batteryType){
        this.model = model; this.idle_time = idle_time; hoursTalk = 0; this.batteryType = batteryType;
    }
    public Battery(string model, float idle_time, float hoursTalk, BatteryType batteryType){
        this.model = model; this.idle_time = idle_time; this.hoursTalk = hoursTalk; this.batteryType = batteryType;
    }
}