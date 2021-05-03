using System;

class GSM{
    string model, manufacturer, owner;
    float price;
    Battery battery;
    Screen screen;
    public static GSM nokiaN95;
    public GSM(string manufacturer, float price, Battery battery, Screen screen){
        this.model = null;
        this.manufacturer = manufacturer;
        this.owner = null;
        this.price = price;
        this.battery = battery;
        this.screen = screen;
    }
    public GSM(string model, string manufacturer, string owner, float price, Battery battery, Screen screen){
        this.model = model;
        this.manufacturer = manufacturer;
        this.owner = owner;
        this.price = price;
        this.battery = battery;
        this.screen = screen;
    }

    public static void displayNokiaN95(){
        Console.WriteLine(nokiaN95);
    }

    override public string ToString(){
        return String.Format("Model: {0}\nManufacturer: {1}\nOwner: {2}\nPrice: ${3}\n",model,manufacturer,owner,price) +
        String.Format("Battery\n\tModel: {0}\n\tIdle Time: {1} hrs\n\tHours Talk: {2} hrs\n\tType: {3}\n", battery.model, battery.idle_time, battery.hoursTalk, battery.batteryType) +
        String.Format("Screen\n\tSize: {0}\"\n\tColor: {1}", screen.size, screen.color);
    }
}