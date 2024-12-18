#include <iostream>
#include <cstring>
#include <list>
#include <algorithm>
#include <numeric>
#include <functional>
#include <random>
#include <iterator>
#include <fstream>
#include <stdexcept>  // Для invalid_argument
#include "Worker.h"

using namespace std;



// Маніпулятор для додавання табуляції 
ostream& add_tab(ostream& os) 
{
    os << "     ";
    return os;
}


// Функтор для порівняння зарплати
struct SalaryComparator {
    // Оператор виклику (перевантаження operator())
    // Використовується для порівняння двох працівників по їх зарплаті
    bool operator()(const Worker& w1, const Worker& w2) const {
        return w1.getSalary() < w2.getSalary();  // Порівнюємо зарплати
    }
};

// Лямбда-функція для визначення працівників з зарплатою більше 4000
auto salaryGreaterThan4000 = [](const Worker& w) {
    return w.getSalary() > 4000;  // Повертає true, якщо зарплата працівника більше 4000
    };

int main() {
        // Створення списку працівників
        list<Worker> employees = {
            Worker("John", "Pork", "Smith", Senior, 2015, 500),
            Worker("Jane", "Doe", "Johnson", Middle, 2018, 4500),
            Worker("Alex", "Brown", "Davis", Junior, 2021, 300),
            Worker("Sam", "Green", "Taylor", Lead, 2012, 800)
        };

        // 1. Алгоритм, що не модифікує: Пошук максимального елемента за допомогою лямбда-функції
        cout << "1. Finding the employee with the highest salary:\n";
        auto max_elem = max_element(employees.begin(), employees.end(), [](const Worker& a, const Worker& b) {
            return a.getSalary() < b.getSalary(); // Порівнюємо зарплати
            });
        if (max_elem != employees.end()) {
            max_elem->printDetails();
        }

        // 2. Алгоритм, що модифікує: Збільшення зарплати кожного працівника на 500
        cout << "\n2. Increasing all employee salaries by 500:\n";
        for_each(employees.begin(), employees.end(), [](Worker& w) {
            w.setSalary(w.getSalary() + 500);
            });
        for (const auto& worker : employees) {
            worker.printDetails();
        }

        // 3. Алгоритм видалення: Видалення працівників із зарплатою більше 4000
        cout << "\n3. Removing employees with salary > 4000:\n";
        employees.remove_if(salaryGreaterThan4000);
        for (const auto& worker : employees) {
            worker.printDetails();
        }

        // 4. Алгоритм перестановки: Перемішування працівників
        cout << "\n4. Shuffling the remaining employees:\n";
        vector<Worker> temp(employees.begin(), employees.end());
        random_device rd;
        mt19937 g(rd());
        shuffle(temp.begin(), temp.end(), g);
        employees.assign(temp.begin(), temp.end());
        for (const auto& worker : employees) {
            worker.printDetails();
        }

        // 5. Алгоритм сортування: Сортування працівників за зарплатою
        cout << "\n5. Sorting employees by salary:\n";
        employees.sort(SalaryComparator());
        for (const auto& worker : employees) {
            worker.printDetails();
        }

        // 6. Алгоритм для впорядкованих діапазонів: Перевірка на відсортованість
        cout << "\n6. Checking if employees are sorted by salary:\n";
        if (is_sorted(employees.begin(), employees.end(), SalaryComparator())) {
            cout << "Employees are sorted by salary.\n";
        }
        else {
            cout << "Employees are not sorted by salary.\n";
        }

        // 7. Чисельний алгоритм: Підсумовування зарплат
        cout << "\n7. Calculating the total salary of all employees:\n";
        int total_salary = accumulate(employees.begin(), employees.end(), 0, [](int sum, const Worker& w) { 
            // параметри - ітератори, які визначають діапазон елементів для обробки, початкове значення для підсумовування, лямбда - вираз, що визначає, як обчислюється наступне накопичене значення.
            return sum + w.getSalary();
            });
        cout << "Total salary: " << total_salary << "\n";

        // Демонстрація зворотнього ітератора
        cout << "\n8. Displaying employees in reverse order:\n";
        for (auto it = employees.rbegin(); it != employees.rend(); ++it) {
            it->printDetails();
        }

        // Демонстрація вставки елементів за допомогою вставного ітератора
        cout << "\n9. Demonstrating insertion of new employees:\n";
        list<Worker> newEmployees;
        insert_iterator<list<Worker>> inserter(newEmployees, newEmployees.begin());
        *inserter = Worker("Olivia", "Miller", "Lee", Senior, 2017, 5500);
        *inserter = Worker("William", "Brown", "Clark", Lead, 2014, 7500);
        for (const auto& worker : newEmployees) {
            worker.printDetails();
        }

        // Демонстрація потокового ітератора
        cout << "\n10. Displaying employees using ostream_iterator:\n";
        copy(employees.begin(), employees.end(), ostream_iterator<Worker>(cout, "\n"));



        list<Worker> validWorkers;       // Об'єкти, введені коректно
        list<string> fatalErrors;        // Введення з фатальними помилками
        list<string> logicalErrors;      // Введення з логічними помилками

        char continueInput = 'y';
        while (continueInput == 'y')
        {
            try {
                Worker w("", "", "", Junior, 0, 0);  // Початковий об'єкт

                cout << "Enter data for the worker:" << endl;
                cin >> w;  // Спроба введення працівника

                // Якщо введення успішне, додаємо до списку коректних
                validWorkers.push_back(w);
                cout << "Worker added successfully!" << endl;

            }
            catch (const MyException& e) {
                // Логічна помилка, додаємо опис до logicalErrors
                logicalErrors.push_back(e.what());
                cerr << "Logical error: " << e.what() << endl;

            }
            catch (const exception& e) {
                // Фатальна помилка, додаємо опис до fatalErrors
                fatalErrors.push_back(e.what());
                cerr << "Fatal error: " << e.what() << endl;
            }

            cout << "Continue input? (y/n): ";
            cin >> continueInput;
        }

        // Виведення результатів
        cout << '\n' << add_tab << "Entered workers (valid data):" << endl;
        for (const auto& worker : validWorkers) {
            cout  << worker << endl;
        }

        cout << '\n' << add_tab << "Fatal errors during input:" << endl;
        for (const auto& error : fatalErrors) {
            cout << error << endl;
        }

        cout << '\n' << add_tab << "Logical errors during input:" << endl;
        for (const auto& error : logicalErrors) {
            cout << error << endl;
        }


        return 0;
    }

 
