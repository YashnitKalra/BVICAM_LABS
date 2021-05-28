using System;
using System.Web;
using System.Web.UI;

namespace Assignment_B
{

    public partial class BP_2 : System.Web.UI.Page
    {
        public void ChangeImage(object sender, EventArgs args)
        {
            switch (storeList.SelectedItem.Text)
            {
                case "Soap":
                    image.ImageUrl = "https://media-services.digital-rb.com/s3/live-productcatalogue/sys-master/images/h52/hd4/8867996598302/DettolOriginalSoap.jpg?width=1280&height=1280";
                    break;
                case "Toothpaste":
                    image.ImageUrl = "http://pngimg.com/uploads/toothpaste/toothpaste_PNG18349.png";
                    break;
                case "Butter":
                    image.ImageUrl = "https://www.pngpix.com/wp-content/uploads/2016/10/PNGPIX-COM-Butter-PNG-Transparent-Image.png";
                    break;
                case "Jam":
                    image.ImageUrl = "https://pngimg.com/uploads/jam/jam_PNG119.png";
                    break;
            }
        }

        public void GetPrice(object sender, EventArgs args)
        {
            switch (storeList.SelectedItem.Text)
            {
                case "Soap":
                    price.InnerText = "90";
                    break;
                case "Toothpaste":
                    price.InnerText = "70";
                    break;
                case "Butter":
                    price.InnerText = "45";
                    break;
                case "Jam":
                    price.InnerText = "150";
                    break;
            }
        }
    }
}
