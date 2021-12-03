type Point = (Float, Float)

distBetween :: Point -> Point -> Float
distBetween (x1, y1) (x2, y2) = sqrt $ (x1-x2)^2 + (y1-y2)^2

ar :: (Point, Point, Point) -> Float
ar (v1, v2, v3) =
    let a = distBetween v1 v2
        b = distBetween v2 v3
        c = distBetween v3 v1
        s = 0.5 * (a + b + c)
    in sqrt $ s * (s - a) * (s - b) * (s - c)

-- More info in https://hackage.haskell.org/package/hgeometry-0.12.0.2/candidate/docs/src/Data.Geometry.Triangle.html#Triangle
-- search by: 
  --  "cheks if the triangle is degenerate"
  --  "Get the inscribed disk. Returns Nothing if the triangle is degenerate, i.e. if the points are colinear."
