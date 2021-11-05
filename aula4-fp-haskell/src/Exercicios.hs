module Exercicios
    ( 
        doubleOfNumbers,
        quadrupleOfNumber,
        distanceBetweenTwoPoints,
        calculateHypotenuseOfTriangle,
        Point
    ) where

-- Exercicio 1: Função para calcular o dobro de um número.
doubleOfNumbers :: Integer -> Integer -- declaração da função
doubleOfNumbers number = 2 * number -- definição da função

-- Exercício 2: Função para calcular o quádruplo de um número,
-- Utilizando o Exercício 1.
quadrupleOfNumber number = doubleOfNumbers(doubleOfNumbers(number)) 

-- Exercício 3: Função para calcular a distância entre dois pontos.
type Point = (Float, Float)

distanceBetweenTwoPoints :: Point -> Point -> Float
distanceBetweenTwoPoints (coordX1,coordY1) (coordX2,coordY2) = 
    sqrt (xCoordResult*xCoordResult + yCoordResult*yCoordResult) 
    where
        xCoordResult = coordX1 - coordX2
        yCoordResult = coordY1 - coordY2

-- Exercício 4: Função para calcular o valor da hipotenusa.
calculateHypotenuseOfTriangle catetoA catetoB = sqrt $ catetoA**2 + catetoB**2

