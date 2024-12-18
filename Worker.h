#include <iostream>
#include <random>
#include <fstream>
#include <stdexcept>  // Для invalid_argument

using namespace std;
#pragma once

enum position { Junior, Middle, Senior, Lead };


//Власний клас виключень
class MyException : public exception {
private:
    string message;  // Член класу для зберігання повідомлення про помилку

public:
    // Конструктор класу, який ініціалізує повідомлення
    MyException(const string& msg) : message(msg) {}

    // Переозначення методу what() для повернення повідомлення
    const char* what() const override {
        return message.c_str();  // Повертає C-стрічку з повідомленням
    }
};


// Перевантаження оператору вводу для enum
istream& operator>>(istream& is, position& pos)
{
    string input;
    is >> input;

    //Обробка власного класу виключень
    try {
        if (input != "Junior" && input != "Middle" && input != "Senior" && input != "Lead")
        {
            // Генерація виключення
            throw MyException("Position must be Junior, Middle, Senior or Lead");
        }
    }
    catch (const MyException& e) {
        // Обробка виключення
        cerr << "Error: " << e.what() << '\n';
        throw;
    }


    // Порівнюємо введене значення та присвоюємо відповідний елемент enum
    if (input == "Junior") {
        pos = position::Junior;
    }
    else if (input == "Middle") {
        pos = position::Middle;
    }
    else if (input == "Senior") {
        pos = position::Senior;
    }
    else if (input == "Lead") {
        pos = position::Lead;
    }

    return is;
}




class Worker {
private:
    char* Name;
    char* Surname;
    char* Patronymic;
    position Position;
    int year;
    int salary;

public:
    // Конструктор
    Worker(const char* name, const char* surname, const char* patronymic, position pos, int y, int sal) {
        Name = new char[strlen(name) + 1];
        strcpy_s(Name, strlen(name) + 1, name);
        Surname = new char[strlen(surname) + 1];
        strcpy_s(Surname, strlen(surname) + 1, surname);
        Patronymic = new char[strlen(patronymic) + 1];
        strcpy_s(Patronymic, strlen(patronymic) + 1, patronymic);
        Position = pos;
        year = y;
        salary = sal;
    }

    // Конструктор копіювання
    Worker(const Worker& other) {
        Name = new char[strlen(other.Name) + 1];
        strcpy_s(Name, strlen(other.Name) + 1, other.Name);
        Surname = new char[strlen(other.Surname) + 1];
        strcpy_s(Surname, strlen(other.Surname) + 1, other.Surname);
        Patronymic = new char[strlen(other.Patronymic) + 1];
        strcpy_s(Patronymic, strlen(other.Patronymic) + 1, other.Patronymic);
        Position = other.Position;
        year = other.year;
        salary = other.salary;
    }

    // Оператор присвоєння
    Worker& operator=(const Worker& other) {
        if (this != &other) {
            delete[] Name;
            delete[] Surname;
            delete[] Patronymic;
            Name = new char[strlen(other.Name) + 1];
            strcpy_s(Name, strlen(other.Name) + 1, other.Name);
            Surname = new char[strlen(other.Surname) + 1];
            strcpy_s(Surname, strlen(other.Surname) + 1, other.Surname);
            Patronymic = new char[strlen(other.Patronymic) + 1];
            strcpy_s(Patronymic, strlen(other.Patronymic) + 1, other.Patronymic);
            Position = other.Position;
            year = other.year;
            salary = other.salary;
        }
        return *this;
    }

    // Сеттер для Name
    void setName(const char* name) {
        delete[] Name;
        Name = new char[strlen(name) + 1];
        strcpy_s(Name, strlen(name) + 1, name);
    }

    // Сеттер для Surname
    void setSurname(const char* surname) {
        delete[] Surname;
        Surname = new char[strlen(surname) + 1];
        strcpy_s(Surname, strlen(surname) + 1, surname);
    }

    // Сеттер для Patronymic
    void setPatronymic(const char* patronymic) {
        delete[] Patronymic;
        Patronymic = new char[strlen(patronymic) + 1];
        strcpy_s(Patronymic, strlen(patronymic) + 1, patronymic);
    }

    // Сеттер для Position
    void setPosition(position pos) {
        Position = pos;
    }

    // Сеттер для year
    void setYear(int y) {
        year = y;
    }

    // Сеттер для salary
    void setSalary(int sal) {
        salary = sal;
    }

    // Геттери
    const char* getName() const { return Name; }
    const char* getSurname() const { return Surname; }
    const char* getPatronymic() const { return Patronymic; }
    int getSalary() const { return salary; }
    int getYear() const { return year; }
    const position getPosition() const { return Position; }

    // Метод для виведення даних
    void printDetails() const {
        cout << "Name: " << Name << "\n";
        cout << "Surname: " << Surname << "\n";
        cout << "Patronymic: " << Patronymic << "\n";
        cout << "Position: ";
   
            switch (Position) {
            case 0:
                cout << "Junior\n";
                break;
            case 1:
                cout << "Middle\n";
                break;
            case 2:
                cout << "Senior\n";
                break;
            case 3:
                cout << "Lead\n";
                break;
            }

        cout << "Year: " << year << '\n';
        cout << "Salary: " << salary << "\n" << "\n";
    }

    // Деструктор
    ~Worker() {
        delete[] Name;
        delete[] Surname;
        delete[] Patronymic;
    }



    //перевантаження оператору вводу >> 
    friend istream& operator>>(istream& is, Worker& p) {
        char buffer[256]; // Тимчасовий буфер для введення рядків

        cout << "Enter the name of an employee: ";
        is >> buffer; // Читаємо у тимчасовий буфер
        delete[] p.Name; // Видаляємо стару пам’ять
        p.Name = new char[strlen(buffer) + 1]; // Виділяємо нову
        strcpy_s(p.Name, strlen(buffer) + 1, buffer); // Копіюємо дані

        cout << "Enter the surname of an employee: ";
        is >> buffer;
        delete[] p.Surname;
        p.Surname = new char[strlen(buffer) + 1];
        strcpy_s(p.Surname, strlen(buffer) + 1, buffer);

        cout << "Enter the patronymic of an employee: ";
        is >> buffer;
        delete[] p.Patronymic;
        p.Patronymic = new char[strlen(buffer) + 1];
        strcpy_s(p.Patronymic, strlen(buffer) + 1, buffer);

        cout << "Enter the position of an employee (Junior, Middle, Senior or Lead):";
        is >> p.Position;

        cout << "Enter the salary of an employee ";
        is >> p.salary;
        try {
            if (p.salary < 0)
            {
                throw invalid_argument("Salary cant be less than 0.");
            }
        }
    catch (const invalid_argument& e) {
        cerr << "Error: " << e.what() << endl;
        // Скидаємо стан потоку та очищаємо буфер
        is.clear(); // Скидає флаг помилки вводу
        is.ignore(numeric_limits<streamsize>::max(), '\n'); // Очищує залишок буфера
        throw;
    }

       
         cout << "Enter the year of an employee: ";
         is >> p.year;

            try { // Перевірка на помилку вводу
                if (cin.fail()) {
                    throw invalid_argument("Year must be a valid number.");
                }

                // Перевірка на правильність діапазону року
                if (p.year < 1900 || p.year > 2024) {
                    throw out_of_range("A year must be in range [1900; 2024].");
                }

            }

            catch (const invalid_argument& e) {
                cerr << "Error: " << e.what() << endl;
                // Скидаємо стан потоку та очищаємо буфер
                is.clear(); // Скидає флаг помилки вводу
                is.ignore(numeric_limits<streamsize>::max(), '\n'); // Очищує залишок буфера
                throw;
            }

            catch (const out_of_range& e) {
                cerr << "Error: " << e.what() << endl;
                // Скидаємо стан потоку та очищаємо буфер
                is.clear(); // Скидає флаг помилки вводу
                is.ignore(numeric_limits<streamsize>::max(), '\n'); // Очищує залишок буфера
                throw;
            }
               

    }




    //перевантаження оператору виводу <<
    friend ostream& operator<<(ostream& os, const Worker& w) {
        os << "Name: " << w.Name << ", \n"
            << "Surname: " << w.Surname << ", \n"
            << "Surname: " << w.Patronymic << ", \n"
            << "Position: ";
        if (w.Position == 0)
        {
            os << "Junior,\n ";
        }
        else if (w.Position == 1)
        {
            os << "Middle,\n";
        }
        else if (w.Position == 2)
        {
            os << "Senior,\n";
        }
        else if (w.Position == 3)
        {
            os << "Lead,\n";
        }
        os << "Year: " << w.year << ", \n";
        
        os << "Salary: " << w.salary << "\n";
        return os;
    }



    void writeToFile(const string& filename) {
        ofstream ofs(filename);  // Створюємо об'єкт вихідного потоку для запису у файл
        if (ofs) {  // Перевіряємо, чи вдалось відкрити файл
            ofs << *this;  // Використовуємо перевантажений оператор << для запису об'єкта в файл
            ofs.close();  // Закриваємо файл після запису
        }
        else {
            cerr << "Error opening file for writing.\n";  // Якщо файл не вдалося відкрити, виводимо помилку
        }
    }

    void readFromFile(const string& filename) {
        ifstream ifs(filename);  // Створюємо об'єкт вхідного потоку для читання з файлу
        if (ifs) {  // Перевіряємо, чи вдалось відкрити файл
            ifs >> *this;  // Використовуємо перевантажений оператор >> для читання об'єкта з файлу
            ifs.close();  // Закриваємо файл після читання
        }
        else {
            cerr << "Error opening file for reading.\n";  // Якщо файл не вдалося відкрити, виводимо помилку
        }
    }


};
