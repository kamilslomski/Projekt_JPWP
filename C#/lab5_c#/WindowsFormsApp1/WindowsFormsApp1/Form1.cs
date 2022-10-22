using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApp1
{
    public partial class Form1 : Form
    {
        int x, y, promien = 20;
        Info informacje;



        public Form1()
        {
            File.WriteAllText("Info.txt", String.Empty);
            InitializeComponent();
            this.panelRysowania.MouseWheel += panelRysowania_MouseWheel;

        }

        private void panelRysowania_MouseWheel(object sender, MouseEventArgs e)

        {

            if (promien > 10 && promien < 30)
            {
                if (e.Delta > 0)
                {
                    promien += 2;
                }
                else promien -= 2;
            }
            else if (promien == 10)
            {
                if (e.Delta > 0) promien += 2;
            }
            else if (promien == 30)
            {
                if (e.Delta < 0) promien -= 2;
            }

        }

        private void saveButton_Click(object sender, EventArgs e)
        {
            informacje.Zapisz();
        }

        private void infoLabel_Click(object sender, EventArgs e)
        {

        }

        private void panelRysowania_MouseClick(object sender, MouseEventArgs e)
        {
            informacje = new Info(e.X, e.Y, wyborKoloru.SelectedIndex, promien);

            infoLabel.Text = informacje.Wyswietl();

            Point p = new Point(e.X, e.Y);
            x = p.X;
            y = p.Y;
            panelRysowania.Invalidate();
        }

        private void panelRysowania_Paint(object sender, PaintEventArgs e)
        //
        {
            Graphics g = panelRysowania.CreateGraphics();
            Pen p = new Pen(Color.Black);

            SolidBrush sb = new SolidBrush(Color.Black);
            g.DrawEllipse(p, x - 5, y - 5, promien, promien);


            if (wyborKoloru.SelectedIndex == 0)
            {
                p.Color = Color.Black;
                g.DrawEllipse(p, x - 5, y - 5, promien, promien);
                

            }

            if (wyborKoloru.SelectedIndex == 1)
            {
                p.Color = Color.Green;
                g.DrawEllipse(p, x - 5, y - 5, promien, promien);

            }

            if (wyborKoloru.SelectedIndex == 2)
            {
                p.Color = Color.Red;
                g.DrawEllipse(p, x - 5, y - 5, promien, promien);

            }

            if (wyborKoloru.SelectedIndex == 3)
            {
                p.Color = Color.Blue;
                g.DrawEllipse(p, x - 5, y - 5, promien, promien);

            }

        }






    }
}
