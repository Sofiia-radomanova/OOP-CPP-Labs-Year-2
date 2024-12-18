#pragma once

class Series {
public:
    double start_number;  // Перший член прогресії
    double increase;      // Різниця або знаменник прогресії

public:
    // Конструктор з параметрами
    Series(double start_number = 0, double increase = 0) {
        this->start_number = start_number;
        this->increase = increase;
    }

    // Чистий віртуальний метод для обчислення i-го члена прогресії
    virtual void calculateTerm(int i) = 0;
    /*{
         std::cout << "Метод визначення i-го члена в базовому класі Series.\n";
     }*/


     // Чистий віртуальний метод для обчислення суми прогресії
    virtual void calculateSum(int n) = 0;
    /* {
          std::cout << "Метод визначення суми в базовому класі Series.\n";
      }*/

      // Метод GetInfo для виведення інформації
    void getInfo(int i, int n) {
        std::cout << "Інформація про прогресію:\n";
        calculateTerm(i);
        calculateSum(n);
    }

    virtual ~Series() {
        std::cout << "Спрацював деструктор для базового класу \n";
    };
};