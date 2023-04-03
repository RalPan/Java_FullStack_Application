DROP DATABASE IF EXISTS fodmapDB;
CREATE DATABASE fodmapDB;

USE fodmapDB;

CREATE TABLE ingredients(
    ingredientID INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    quantity int NOT NULL,
    unit VARCHAR(30) NOT NULL,
    Fructose int NOT NULL,
    Lactose int NOT NULL,
    Sorbitol int NOT NULL,
    Mannitol int NOT NULL,
    GOS int NOT NULL,
    Fructans int NOT NULL
);

INSERT INTO ingredients
values 
(1,'onion', 30,'g', 0, 0, 0, 0, 0, 113),
(2,'feta cheese', 40,'g', 1.6, 9, 0, 0, 15, 1.5),
(3,'tomato', 75,'g', 90, 0, 0, 0, 0, 1),
(4,'cucumber', 100,'g', 150, 0, 0, 0, 0, 0)
;
CREATE TABLE users(
    userID INT PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(100) NOT NULL,
    contact VARCHAR(30)
);
INSERT INTO users
values 
(null,'Raluca', '0780675397')
;

CREATE TABLE tolerance(
    toleranceID INT PRIMARY KEY AUTO_INCREMENT,
    fk_userID int unique ,
    Fructose int,
    Lactose int,
    Sorbitol int,
    Mannitol int,
    GOS int,
    Fructans int,
    foreign key (fk_userID) references users(userID)
);
INSERT INTO tolerance
values 
(1,1, 0, 0, 0, 0, 0, 50)
;

CREATE TABLE meals(
    mealID INT PRIMARY KEY AUTO_INCREMENT,
    toleranceID int NOT NULL,
    name varchar(30) NOT NULL,
    ingredients varchar(100) NOT NULL,
    time TIMESTAMP,
    FOREIGN KEY fk_Meals_tolerance (toleranceID)
        REFERENCES tolerance(toleranceID)
);
INSERT INTO meals
values 
(1, 1, 'Greek salad', 'tomato: 30g, onion: 10g, cucumber: 70g, feta cheese: 40g', now())
;
create table MealIngredient(
	mealID int,
	ingredientID int,
    PRIMARY KEY pk_MealIngredient (mealID, ingredientID),
    FOREIGN KEY fk_MealIngredient_Meal (mealID)
        REFERENCES meals(mealID),
    FOREIGN KEY fk_MealIngredient_Ingredient (ingredientID)
        REFERENCES ingredients(ingredientID)
);

INSERT INTO MealIngredient
values 
(1, 1),
(1, 2),
(1, 3),
(1, 4)
;