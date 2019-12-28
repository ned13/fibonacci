# fibonacci
Code written in different languages to compare relative performance

This example comes from Medium article: https://medium.com/swlh/compiled-vs-interpreted-code-performance-e1a63299760b

## How to Run
### C#
```bash
dotnet run -c Release
```

### Java
```
javac ./Fibonacci.java
java Fibonacci
```

### Node.js
```bash
node fibonacci.js
```

### Go
```bash
go run ./fibonacci.go
```

### Python
```bash
python3 ./fibonacci.py
```

### Result
#### EXECUTION_TIMES = 200, CAL_FAB_TIMES = 5000000
- OS: MacOS
- C#: DotNet Core 2.2.401 -> 3.1.100
- Java: openjdk version "1.8.0_222"
- Node: v10.16.3
- Go: go version go1.13.5 darwin/amd64
- Python: Python 3.7.5

| Language      	    | Average              	|
|----------------------	|----------------------	|
| C# dotnetcore 2.2.401	| 43.8677872ns         	|
| C# dotnetcore 3.1.1	| 46.6271794ns          |
| Java 1.8.0_222        | 65.345000ns          	|
| Java version "13.0.1" | 76.015000ns          	|
| Node.js       	    | 162ns                	|
| Go            	    | 63.996324307999984ns 	|
| Python           	    | 7245.97070ns 	        |
