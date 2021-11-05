module Main where

import Lib
import Exercicios

main :: IO ()
main = do

  putStrLn "\n1. Escreva uma função para calcular o dobro de um número."
  putStr "O dobro do número 5 = "
  print(doubleOfNumbers 5)

  putStrLn "\n2. Escreva uma função para quadruplicar um número usando a função definida no item anterior."
  putStr "O quádruplo do número 5 = "
  print(quadrupleOfNumber 5)

  putStrLn "\n3. Defina uma função para calcular a distância entre dois pontos (num plano)."
  putStr "A distância entre o ponto(5,10) e o ponto(3,5) (num plano) = "
  print(distanceBetweenTwoPoints (5 , 10) (3 , 5) )

  putStrLn "\nDadas as medidas dos catetos de um triângulo retângulo, retornar o valor de sua hipotenusa."
  putStrLn "Informe o cateto a"
  catetoA <- readLn
  putStrLn "Informe o cateto b"
  catetoB <- readLn
  putStr "A hipotenusa do triângulo = "
  print(calculateHypotenuseOfTriangle catetoA catetoB)
