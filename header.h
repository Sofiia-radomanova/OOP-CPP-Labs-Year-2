#pragma once
#include <iostream> 
#include <cmath>

using namespace std;

class Point
{

private:
	int first; // coordinate x
	int second; // coordinate y
	static int count; //статичний метод належить самому класу, а не його екземплярам, тому його можна викликати без створення об'єктів цього класу


public:
	Point()
	{
		cout << "Конструктор без параметрів спрацював!\n";
		count++;
	}

	Point(int x, int y)
	{
		this->first = x;
		this->second = y;
		cout << "Конструктор з параметрами спрацював! \n";
		count++;
	}

	// Конструктор копіювання
	Point(const Point& other)
	{
		first = other.first;
		second = other.second;
		cout << "Конструктор копіювання викликано\n";
		count++;
	}


	~Point()
	{
		cout << "Деструктор спрацював!!\n";
		count--;
	}

	// getter for first and second coordinate
	int getX() { return first; }

	int getY() { return second; }

	static int get_count() { return count; }

	// setter for first and second coordinate
	void setX(int coordinateX) { first = coordinateX; }

	void setY(int coordinateY) { second = coordinateY; }

	void print() { cout << "X: " << first << "  Y: " << second << '\n'; }


	//Завдання 2. Перевантаження операцій введення/виведення

	friend ostream& operator<<(ostream& os, const Point& p) // friend дає доступ до private поля; передаємо посилання на об'єкт типу ostream куди буде записано результат та на об'єкт класу Point
	{
		os << "(" << p.first << ", " << p.second << ")"; // os - посилання на поток виводу
		return os;
	}

	friend istream& operator>>(istream& is, Point& p)
	{
		
		is >> p.first >> p.second;
		return is;
	}

	// Метод для обчислення відстані до початку координат
	double distance()
	{
		return sqrt(pow(first, 2) + pow(second, 2));
	}

	// Перевантаження оператора + для obj1 + obj2
	Point operator+(const Point& other)
	{
		return Point(first + other.first, second + other.second);
	}

	// Перевантаження оператора + для obj1 + число
	Point operator+(int value)
	{
		return Point(first + value, second + value);
	}

	// Перевантаження оператора + для число + obj1
	friend Point operator+(int value, const Point& p)
	{
		return Point(p.first + value, p.second + value);
	}

	// Префіксна форма ++obj
	Point& operator++()
	{
		++first;
		++second;
		return *this;
	}

	// Постфіксна форма obj++
	Point operator++(int)
	{
		Point temp = *this; //  Створюємо копію поточного об'єкта, розіменування вказівника
		first++;
		second++;
		return temp;		//  Повертаємо копію об'єкта з початковими значеннями
	}


};

