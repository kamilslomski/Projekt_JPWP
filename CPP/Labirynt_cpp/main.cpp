//POP 2020-12-08 projekt 1 S�omski Kamil EiT 6 184743 Dev c++ TDM-GCC 4.9.2 64-bit
#include <iostream>
#include <cstdlib>
#include <cstring>
#include <ctime>
using namespace std;


void pulapki(int p, char m[20][20]); //funkcja odpowiadaj�ca za losowanie liczby pu�apek na mapie
void rysowanie(char m[20][20]);	//rysuje map�
void polozenie(char m[20][20], int x, int y);	//odpowiada za zmien� widoku mapy oraz zmian� po�o�enia gracza

int main()
{
	srand(time(NULL));
	char mapa[20][20];
	int xgracza = 1;
	int ygracza = 19;
	int liczba_pulapek = rand()%3+4;


	strcpy(mapa[0], "------------------ -");
	strcpy(mapa[1], "|--+ +-----+ | | | |");
	strcpy(mapa[2], "|  | | +-----+ +-+ |");
	strcpy(mapa[3], "|--+ | |           |");
	strcpy(mapa[4], "|    | +----+ +----|");
	strcpy(mapa[5], "| +--+      | |    |");
	strcpy(mapa[6], "| |  +------+ |    |");
	strcpy(mapa[7], "| |  |        |    |");
	strcpy(mapa[8], "| |  |  +-----+  +-|");
	strcpy(mapa[9], "| +--+  +--------+ |");
	strcpy(mapa[10], "|                  |");
	strcpy(mapa[11], "|----+ +----+ +--+ |");
	strcpy(mapa[12], "|    | |    |      |");
	strcpy(mapa[13], "|    | |    +------|");
	strcpy(mapa[14], "|--+-+ +----+   +--|");
	strcpy(mapa[15], "|  |        |   |  |");
	strcpy(mapa[16], "|  | +---+  |   |  |");
	strcpy(mapa[17], "|--+ |   |  +---+  |");
	strcpy(mapa[18], "|    |   |         |");
	strcpy(mapa[19], "-#------------------");

	pulapki(liczba_pulapek, mapa);
	rysowanie(mapa);
	polozenie(mapa, xgracza, ygracza);



	return 0;
}

void pulapki(int p, char m[20][20])
{
	for (int i = 0, x,y; i < p; )
	{
		x= rand() % 20;
		y= rand() % 20;
		if (m[x][y] == ' ')
		{
			m[x][y] = '@';
			i++;
		}
	}
}
void rysowanie(char m[20][20])
{
	for (int i = 0; i < 20; i++)
	{
		for (int j = 0; j < 20; j++)
		{
			cout << m[i][j];
		}
		cout << "\n";
	}

	cout << "Gotowy? Wcisnij Enter, aby kontynuowac...";
	cin.get();
	system("cls");
}
void polozenie(char m[20][20], int x, int y)
{
	char ruch;
	int kroki = 0;

	while (true)
	{
		if (m[y - 1][x] == '@' || m[y + 1][x] == '@' || m[y][x + 1] == '@' || m[y][x - 1] == '@') //sprawdzenie czy wok� nas nie ma pu�apki
		{
			cout << "Uwaga, w poblizu znajduje sie pulapka!\n\n";
		}

		if (x < 10 && y < 10)
		{
			for (int i = 0; i < 10; i++)
			{
				for (int j = 0; j < 10; j++)
				{
					cout << m[i][j];
				}
				cout << "\n";
			}
		}
		else if (x >= 10 && y < 10)
		{
			for (int i = 0; i < 10; i++)
			{
				for (int j = 10; j < 20; j++)
				{
					cout << m[i][j];
				}
				cout << "\n";
			}
		}
		else if (x < 10 && y >= 10)
		{
			for (int i = 10; i < 20; i++)
			{
				for (int j = 0; j < 10; j++)
				{
					cout << m[i][j];
				}
				cout << "\n";
			}
		}
		else if (x >= 10 && y >= 10)
		{
			for (int i = 10; i < 20; i++)
			{
				for (int j = 10; j < 20; j++)
				{
					cout << m[i][j];
				}
				cout << "\n";
			}
		}


		cout << "Twoj ruch: ";
		cin >> ruch;
		system("cls");

		switch (ruch)
		{
			case 'w':
			{
				if (y > 0 && (m[y - 1][x ] == ' ' || m[y - 1][x] == '.')) //je�eli przed nami znajduje si� puste miejsce lub kropka mo�na ruszy� si� do przodu, pilnuje tak�e aby�my nie opu�cili mapy
				{
					m[y][x] = '.';
					y--;
					m[y][x] = '#';
					kroki++;
				}
				else if (m[y - 1][x] == '@')
				{
					cout << "Przegrales!!! Liczba wykonanych krokow: " << kroki; ;
					return;
				}
				break;
			}
			case 's':
			{
				if (y <19 && (m[y + 1][x] == ' ' || m[y + 1][x] == '.')) //podobnie jak wy�ej, tylko za nami i reszta case'ow intuicyjnie tak samo
				{
					m[y][x] = '.';
					y++;
					m[y][x] = '#';
					kroki++;
				}
				else if (m[y + 1][x] == '@')
				{
					cout << "Przegrales!!! Liczba wykonanych krokow: " << kroki;
					return;
				}
				break;
			}
			case 'a':
			{
				if (x > 0 && (m[y][x - 1] == ' ' || m[y][x - 1] == '.'))
				{
					m[y][x] = '.';
					x--;
					m[y][x] = '#';
					kroki++;
				}
				else if (m[y][x - 1] == '@')
				{
					cout << "Przegrales!!! Liczba wykonanych krokow: " << kroki; ;
					return;
				}
				break;
			}
			case 'd':
			{
				if (x < 19 && (m[y][x + 1] == ' ' || m[y][x + 1] == '.'))
				{
					m[y][x] = '.';
					x++;
					m[y][x] = '#';
					kroki++;
				}
				else if (m[y][x + 1] == '@')
				{
					cout << "Przegrales!!! Liczba wykonanych krokow: " << kroki; ;
					return;
				}
				break;
			}
			default:
			{
				break;
			}

		}

		if (x == 18 && y == 0) // jezeli znajdujemy sie na polu w prawym g�rnym - koniec gry
		{
			cout << "Wygrales!!! Liczba wykonanych krokow: " << kroki;
			return;
		}

	}

}
