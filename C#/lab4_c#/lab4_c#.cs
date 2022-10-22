using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab4_184743
{
    class Program
    {
        public static List<Matura> kolekcja = new List<Matura>();
        delegate void Deleg(String str);
        static void Main(string[] args)
        {
            Matura przedmiot1 = new MaturaZMatematyki();
            Matura przedmiot2 = new MaturaZJezyka(Matura.Jezyk.angielski);
            Matura przedmiot3 = new MaturaZJezyka(Matura.Jezyk.niemiecki);

            kolekcja.Add(przedmiot1);
            kolekcja.Add(przedmiot2);
            kolekcja.Add(przedmiot3);

            przedmiot1.OpiszZadanie();
            przedmiot2.OpiszZadanie();
            przedmiot3.OpiszZadanie();

            przedmiot1.Oceny("Slomski");
            przedmiot2.Oceny("Kaczmarek");
            przedmiot3.Oceny("Plotka");
            Console.WriteLine(Environment.NewLine);

            Program program = new Program();
            program.ObliczSrednia("Slomski");
            program.SprawdzUcznia("Slomski");

            Console.WriteLine(Environment.NewLine);
            program.ObliczSrednia("Plotka");
            program.SprawdzUcznia("Plotka");
            Console.WriteLine(Environment.NewLine);

            Deleg srednia = new Deleg(program.ObliczSrednia);
            Deleg sprawdz = new Deleg(program.SprawdzUcznia);

            bool loop = true;
            while (loop)
            {
                Console.WriteLine("Podaj Nazwisko Ucznia:");
                String N = Console.ReadLine();
             
                Console.WriteLine("1. Oblicz Srednia\n2. Sprawdz Ucznia");
                String wybor = Console.ReadLine();
                
                if (wybor.Equals("1"))
                {
                    srednia(N);
                    loop = false;
                }
                if (wybor.Equals("2"))
                {
                    sprawdz(N);
                    loop = false;
                }
                if (loop == true)
                    Console.WriteLine("Podaj poprawna wartosc!!!");
            }


        }
        public void ObliczSrednia(String nazwisko)
        {
            String temporary = "";
            foreach (Matura item in kolekcja)
                if (item.uczen.Equals(nazwisko))
                    foreach (DictionaryEntry de in item.oceny)
                        temporary = de.Value.ToString();
            Console.WriteLine("Nazwisko: " + nazwisko);
            Console.WriteLine("Oceny: " + temporary);
            temporary.Replace(",", ".");
            String[] temporary2 = new String[kolekcja.Count];
            temporary2 = temporary.Split();
            double srednia = 0;
            
            for (int i = 0; i < temporary2.Length; i++)
                srednia += double.Parse(temporary2[i]);
            srednia = srednia / temporary2.Length;
            Console.WriteLine("Srednia: " + srednia);
        }

        public void SprawdzUcznia(String nazwisko)
        {
            String temporary = "";
            foreach (Matura item in kolekcja)
                if (item.uczen.Equals(nazwisko))
                    foreach (DictionaryEntry de in item.oceny)
                        temporary = de.Value.ToString();
            Console.WriteLine("Nazwisko: " + nazwisko);
            Console.WriteLine("Oceny: " + temporary);
            temporary.Replace(",", ".");
            String[] temp2 = new String[kolekcja.Count];
            temp2 = temporary.Split();
            bool poprawka = false;
            for (int i = 0; i < temp2.Length; i++)
                if (double.Parse(temp2[i]) < 3)
                    poprawka = true;
            if (poprawka == true)
                Console.WriteLine("Uczen musi poprawic mature!!!");
            else
                Console.WriteLine("Wszystko zaliczone!!!");
        }
    }
    abstract class Matura
    {
        public enum Jezyk
        {
            polski,
            angielski,
            niemiecki
        };

        public String uczen;

        public Matura(Jezyk jezyk)
        {

        }
        public Matura()
        {

        }
        public abstract void OpiszZadanie();

        public Hashtable oceny = new Hashtable();
        public void Oceny(String nazwisko)
        {
            uczen=nazwisko;
            String[] o = new String[3];
            Random random = new Random(Guid.NewGuid().GetHashCode());
            for (int i = 0; i < 3; i++)
            {
                double ocena = random.Next(2, 5);
                if (ocena < 5)
                    if (random.Next(1, 4) < 3)
                        ocena += 0.5;

                o[i] = ocena.ToString();
            }

            String doTabl = String.Join(" ", o);
            oceny.Add(nazwisko, doTabl);
        }


    }
    

    class MaturaZMatematyki : Matura
    {
        public MaturaZMatematyki() : base()
        {
        }
        public override void OpiszZadanie()
        {
            Console.WriteLine("Polecenie z Matematyki");
        }

    }

    class MaturaZJezyka : Matura
    {

        private Jezyk jezyk;
        public MaturaZJezyka(Jezyk jezyk) : base(jezyk)
        {
           this.jezyk = jezyk;
        }

        public override void OpiszZadanie()
        {
            if (jezyk == Jezyk.angielski) Console.WriteLine("Polecenie z jezyka angielskiego");
            else if (jezyk == Jezyk.niemiecki) Console.WriteLine("Polecenie z jezyka niemieckiego");
            else Console.WriteLine("Polecenie z jezyka polskiego");

        }

    }



}
