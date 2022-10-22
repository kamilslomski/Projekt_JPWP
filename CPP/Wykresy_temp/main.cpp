#include <iostream>
#include <fstream>
#include <iomanip>
#include <cstdio>


#define WHITE '$'
#define BLACK 'X'
#define SHADOW '|'
#define HEIGHT 150

using namespace std;


void candlePrint(float close, float open, float high, float low, float top, float scale, char wykres[][HEIGHT], int n) {
    int i = 0;
    int row = 0;

    row += (top - high) / scale;
    for (i; i < row; i++) {
        wykres[n][i] = ' ';
    }

    if (close > open) //biale
    {
        //high-close - shadow
        row += (high - close) / scale;
        for (i; i < row; i++) {
            wykres[n][i] = SHADOW;
        }
        //close-open - white
        row += (close - open) / scale;
        for (i; i < row; i++) {
            wykres[n][i] = WHITE;
        }
        //open-low - shadow
        row += (open - low) / scale;
        for (i; i < row; i++) {
            wykres[n][i] = SHADOW;
        }
    } else //czarne
    {
        //high-open - shadow
        row += (high - open) / scale;
        for (i; i < row; i++) {
            wykres[n][i] = SHADOW;
        }
        //open-close - black
        row += (open - close) / scale;
        for (i; i < row; i++) {
            wykres[n][i] = BLACK;
        }
        //close-low - shadow
        row += (close - low) / scale;
        for (i; i < row; i++) {
            wykres[n][i] = SHADOW;
        }
    }
    for (i; i < HEIGHT; i++) {
        wykres[n][i] = ' ';
    }
}


int main(){


    int opt,opt_2,year_2, month_2, day_2;

		cout << "Wybierz opcje:" << endl;
		cout << "1: Wybierz plik ktory chcesz wczytac" << endl;
		cout << "2: Podaj zakres i czas startu" << endl;
		cout << "0: Wyjdz z programu" << endl << endl;

		cout << "Podaj swoj wybor: ";
		cin >> opt;

ifstream input_2;
ifstream wejscie;

		switch(opt) {
			case 1:
					cout << "Wybierz plik:" << endl;
					cout << "1: AAPL" << endl;
					cout << "2: INTC" << endl;
					cout << "3: MSFT" << endl;
					cout << "4: NTDOY" << endl;

					cout << "Podaj swoj wybor: ";
					cin >> opt_2;
					switch(opt_2) {
						case 1:
    						input_2.open("AAPL.txt");
    						wejscie.open("AAPL.txt");
							break;
						case 2:
    						input_2.open("INTC.txt");
    						wejscie.open("INTC.txt");
							break;
						case 3:
    						input_2.open("MSFT.txt");
    						wejscie.open("MSFT.txt");
							break;
						case 4:
    						input_2.open("NTDOY.txt");
    						wejscie.open("NTDOY.txt");
							break;

						default:
							cout << "Niepoprawna opcja!" << endl << endl;
							break;
						}

				break;
			case 2:
				cout << "Podaj w kolejnosci dzien, miesiac, rok od ktorego chcesz zaczac"<< endl;
				cin >>day_2;
				cin >> month_2;
				cin>>year_2;
				cout << day_2 << " "<<month_2 << " "<< year_2<<endl;
				cout << "Wybierz plik i podaj numer z: 1.AAPL, 2.INTC, 3.MSFT, 4.NTDOY: ";
					cin >> opt_2;
					switch(opt_2) {
						case 1:
    						input_2.open("AAPL.txt");
    						wejscie.open("AAPL.txt");
							break;
						case 2:
    						input_2.open("INTC.txt");
    						wejscie.open("INTC.txt");
							break;
						case 3:
    						input_2.open("MSFT.txt");
    						wejscie.open("MSFT.txt");
							break;
						case 4:
    						input_2.open("NTDOY.txt");
    						wejscie.open("NTDOY.txt");
							break;
				}
				break;
			case 0:
				break;
			default:
				cout << "Niepoprawna opcja!" << endl << endl;
				break;


	}

    char separator;
    int year,month,day;
    float open,high,low,close,temp;

    float scale;
    int n = 0;
    int m = 0;
    int i = 0;
    float top = 0;
    float bottom = 10000000;
    int number_of_lines = 0;

    while(wejscie >> year >> separator >> month >> separator >> day >> separator >> open >> separator  >> high >> separator >> low >> separator >> close >>  separator >> temp >> separator >> temp)
    {
		number_of_lines++;
        if(high > top)
        {
            top = high;
        }
        if(low < bottom){
            bottom = low;
        }
    }
    scale = (top - bottom)/HEIGHT;

    cout << top << endl;
    cout << bottom << endl;

    int ilosc_dni = 0;
    char wykres[1300][HEIGHT];
    int k = 0;

    while(input_2 >> year >> separator >> month >> separator >> day >> separator >> open >> separator  >> high >> separator >> low >> separator >> close >>  separator >> temp >> separator >> temp)
    {
        candlePrint(close, open, high, low, top, scale, wykres, k);
        k++;
    }

    cout << endl << scale << endl;


	ofstream plik2;
	plik2.open("wykres.txt");
    for (int j = 0; j < HEIGHT; ++j) {
        for (int l = 0; l < number_of_lines; ++l) {
            plik2 << wykres[l][j];
        }
        plik2 << "\r\n";
    }

    return 0;

}
