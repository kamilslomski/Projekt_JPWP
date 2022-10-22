using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WindowsFormsApp1
{
    class Info
    {
        int indeksKoloru;
        int x, y;
        string content, kolor = "Czarny";
        int promien;

        public Info(int x, int y, int indeksKoloru, int promien)
        {
            this.x = x;
            this.y = y;
            this.indeksKoloru = indeksKoloru;
            this.promien = promien;


        }

        public string Wyswietl()
        {
            if (indeksKoloru == 0) kolor = "Czarny";
            else if (indeksKoloru == 1) kolor = "Zielony";
            else if (indeksKoloru == 2) kolor = "Czerwony";
            else if (indeksKoloru == 3) kolor = "Niebieski";


            content = "Kolor: " + kolor + "\n" + "X = " + Convert.ToString(x) + " \nY = " + Convert.ToString(y) + "\nRozmiar = " + promien + "\n \n";

            return content;

        }

        public void Zapisz()
        {


            File.AppendAllText("Info.txt", content);
        }
    }
}
