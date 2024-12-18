#include <iostream>
#include <cmath>
#include <cstdlib> // для rand() і srand()
#include <ctime> // для time()
#include "Series.h"
#include "Arithmetic.h"
#include "Geometric.h"


void foo(Series& obj, int i, int n)
{
    obj.getInfo(i, n);
}

int main() 
{
    double first_number;
    std::cout << "Введіть перший член прогресії: ";
    std::cin >> first_number;

    double increase;
    std::cout << "Введіть різницю/знаменник прогресії: ";
    std::cin >> increase;

    int i;
    std::cout << "Введіть номер i члена прогресії: ";
    std::cin >> i;

    int n;
    std::cout << "Введіть кількість членів прогресії: ";
    std::cin >> n;

    std::cout << '\n';

   // Series defaultSeries(first_number, increase);
    Arithmetic arithmetic(first_number, increase);

    std::cout << '\n';

    Geometric geometric(first_number, increase);

  //  defaultSeries.getInfo(i, n);
    arithmetic.getInfo(i, n);
    geometric.getInfo(i, n);


   std::cout << '\n';


   std::cout << "Створення вказівників на базовий клас для завдання 2\n";
    // Створюємо вказівники на базовий клас і екземпляри дочірніх класів
   // Series* defaultSeriespointer = new Series(first_number, increase);
    Series* arithmeticpointer = new Arithmetic(first_number, increase);
    Series* geometricpointer = new Geometric(first_number, increase);

    // Викликаємо GetInfo для кожного екземпляра
   // std::cout << "\nБазовий клас Series:\n";
   // defaultSeriespointer->getInfo(i, n);

    std::cout << "\nАрифметична прогресія:\n";
    arithmeticpointer->getInfo(i, n);

    std::cout << "\nГеометрична прогресія:\n";
    geometricpointer->getInfo(i, n);


    std::cout << '\n';

    //Task 3
    std::cout << "Демонстрація роботи функції foo для 3 завдання:\n";
   // foo(defaultSeries, i, n);
    foo(arithmetic, i, n);
 


    // Task 4

    std::cout << "\nЗавдання з масивом покажчиків\n";
    srand(time(0)); // Ініціалізація генератора випадкових чисел

    const int SIZE = 5; // Розмір масиву
    Series* seriesArray[SIZE]; // Масив покажчиків на базовий клас

    // Заповнення масиву випадковими екземплярами класів-нащадків
    for (int i = 0; i < SIZE; i++) {
        double first = rand() % 10 + 1; // Генеруємо перший член прогресії
        double step = rand() % 5 + 1; // Генеруємо різницю для арифметичної або знаменник для геометричної прогресії

        if (rand() % 2 == 0) {
            seriesArray[i] = new Arithmetic(first, step); // Створення арифметичної прогресії
        }
        else {
            seriesArray[i] = new Geometric(first, step); // Створення геометричної прогресії
        }
    }

    // Виклик методу GetInfo() для кожного елемента масиву
    int i_1;
    std::cout << "Введіть номер i члена прогресії, який треба знайти для кожної прогресії: ";
    std::cin >> i_1;

    int n_1;
    std::cout << "Введіть кількість перших членів прогресії, суму яких треба знайти: ";
    std::cin >> n_1;

    for (int j = 0; j < SIZE; j++) {
       std::cout << seriesArray[j]->start_number;
       std::cout << seriesArray[j]->increase;
        seriesArray[j]->getInfo(i_1, n_1);
        std::cout << "--------------------------" << '\n';
    }




    // Видалення динамічно створених об'єктів
    for (int j = 0; j < SIZE; j++) {
        delete seriesArray[j];
    }

    //delete defaultSeriespointer;
    delete arithmeticpointer;
    delete geometricpointer;

    return 0;
}
