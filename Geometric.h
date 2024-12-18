#pragma once
class Geometric : public Series {
public:
    // Конструктор з параметрами
    Geometric(double start_number, double increase) : Series(start_number, increase) {}

    // Перекриття методу для визначення i-го члена
    void calculateTerm(int i) override {
        double new_number = start_number * pow(increase, i - 1);
        std::cout << "i-й член геометричної прогресії: " << new_number << "\n";
    }

    // Перекриття методу для визначення суми прогресії
    void calculateSum(int n) override {
        double sum;
        if (increase == 1) {
            sum = start_number * n;
        }
        else {
            sum = start_number * (1 - pow(increase, n)) / (1 - increase);
        }
        std::cout << "Сума перших " << n << " елементів геометричної прогресії: " << sum << "\n";
    }

    ~Geometric()override {
        std::cout << "Спрацював деструктор для геометричної прогресії \n";
    };
};