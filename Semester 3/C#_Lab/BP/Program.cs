using System;

namespace BP
{
    class Program
    {
        static void Main(string[] args)
        {
            GSM.nokiaN95 = new GSM(
                "N95", "Nokia", "Demo User", 70f, 
                new Battery("BL-5F", 192f, 2.5f, BatteryType.Li_Ion),
                new Screen(2.8f, "TFT, 16M")
            );
            GSM.displayNokiaN95();
        }
    }
}
