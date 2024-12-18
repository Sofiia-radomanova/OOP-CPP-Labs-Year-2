#pragma once
class Arithmetic : public Series {
public:
    // Конструктор з параметрами
    Arithmetic(double start_number, double increase) : Series(start_number, increase) {}

    // Перекриття методу для визначення i-го члена
    void calculateTerm(int i) {
        double new_number = start_number + (i - 1) * increase;
        std::cout << "i-й член арифметичної прогресії: " << new_number << "\n";
    }

    // Перекриття методу для визначення суми прогресії
    void calculateSum(int n) {
        double sum = (n / 2.0) * (2 * start_number + (n - 1) * increase);
        std::cout << "Сума перших " << n << " елементів арифметичної прогресії: " << sum << "\n";
    }

    ~Arithmetic()override {
        std::cout << "Спрацював деструктор для арифметичної прогресії \n";
    };
};

