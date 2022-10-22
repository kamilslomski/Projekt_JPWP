
namespace WindowsFormsApp1
{
    partial class Form1
    {
        /// <summary>
        /// Wymagana zmienna projektanta.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Wyczyść wszystkie używane zasoby.
        /// </summary>
        /// <param name="disposing">prawda, jeżeli zarządzane zasoby powinny zostać zlikwidowane; Fałsz w przeciwnym wypadku.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Kod generowany przez Projektanta formularzy systemu Windows

        /// <summary>
        /// Metoda wymagana do obsługi projektanta — nie należy modyfikować
        /// jej zawartości w edytorze kodu.
        /// </summary>
        private void InitializeComponent()
        {
            this.panelRysowania = new System.Windows.Forms.Panel();
            this.saveButton = new System.Windows.Forms.Button();
            this.infoLabel = new System.Windows.Forms.Label();
            this.wyborKoloru = new System.Windows.Forms.ComboBox();
            this.SuspendLayout();
            // 
            // panelRysowania
            // 
            this.panelRysowania.BackColor = System.Drawing.SystemColors.Window;
            this.panelRysowania.Location = new System.Drawing.Point(20, 28);
            this.panelRysowania.Margin = new System.Windows.Forms.Padding(2);
            this.panelRysowania.Name = "panelRysowania";
            this.panelRysowania.Size = new System.Drawing.Size(578, 372);
            this.panelRysowania.TabIndex = 0;
            this.panelRysowania.Paint += new System.Windows.Forms.PaintEventHandler(this.panelRysowania_Paint);
            this.panelRysowania.MouseClick += new System.Windows.Forms.MouseEventHandler(this.panelRysowania_MouseClick);
            // 
            // saveButton
            // 
            this.saveButton.Font = new System.Drawing.Font("Microsoft Sans Serif", 16.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(238)));
            this.saveButton.Location = new System.Drawing.Point(658, 366);
            this.saveButton.Margin = new System.Windows.Forms.Padding(2);
            this.saveButton.Name = "saveButton";
            this.saveButton.Size = new System.Drawing.Size(93, 34);
            this.saveButton.TabIndex = 1;
            this.saveButton.Text = "Zapisz";
            this.saveButton.UseVisualStyleBackColor = true;
            this.saveButton.Click += new System.EventHandler(this.saveButton_Click);
            // 
            // infoLabel
            // 
            this.infoLabel.AutoSize = true;
            this.infoLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 16.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(238)));
            this.infoLabel.Location = new System.Drawing.Point(641, 28);
            this.infoLabel.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.infoLabel.Name = "infoLabel";
            this.infoLabel.Size = new System.Drawing.Size(119, 104);
            this.infoLabel.TabIndex = 2;
            this.infoLabel.Text = "Kolor: \r\nX =\r\nY = \r\nRozmiar = ";
            this.infoLabel.Click += new System.EventHandler(this.infoLabel_Click);
            // 
            // wyborKoloru
            // 
            this.wyborKoloru.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(238)));
            this.wyborKoloru.FormattingEnabled = true;
            this.wyborKoloru.Items.AddRange(new object[] {
            "Czarny",
            "Zielony",
            "Czerwony",
            "Niebieski"});
            this.wyborKoloru.Location = new System.Drawing.Point(646, 169);
            this.wyborKoloru.Margin = new System.Windows.Forms.Padding(2);
            this.wyborKoloru.Name = "wyborKoloru";
            this.wyborKoloru.Size = new System.Drawing.Size(139, 28);
            this.wyborKoloru.TabIndex = 3;
            this.wyborKoloru.Text = "Czarny";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(874, 469);
            this.Controls.Add(this.wyborKoloru);
            this.Controls.Add(this.infoLabel);
            this.Controls.Add(this.saveButton);
            this.Controls.Add(this.panelRysowania);
            this.Margin = new System.Windows.Forms.Padding(2);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Panel panelRysowania;
        private System.Windows.Forms.Button saveButton;
        private System.Windows.Forms.Label infoLabel;
        private System.Windows.Forms.ComboBox wyborKoloru;
    }
}

