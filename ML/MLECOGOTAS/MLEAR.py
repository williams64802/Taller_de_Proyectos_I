import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression
from sklearn.metrics import mean_squared_error, r2_score


data = pd.read_csv('base_de_datos_agua.csv')

X = data[['Ubicacion', 'Numero de habitantes en la casa', 'Fuente de agua']]
columnas_deseadas = ['Consumo de agua enero (m³)', 'Consumo de agua febrero (m³)', 'Consumo de agua marzo (m³)', 'Consumo de agua abril (m³)', 'Consumo de agua mayo (m³)', 'Consumo de agua julio (m³)', 'Consumo de agua agosto (m³)', 'Consumo de agua septiembre (m³)', 'Consumo de agua octubre (m³)']

y = data[columnas_deseadas]

X = pd.get_dummies(X)

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

model = LinearRegression()

model.fit(X_train, y_train)

y_pred = model.predict(X_test)

error_pct = ((abs(y_test - y_pred) / y_test).mean() * 100).mean()

print(f'Porcentaje de error promedio: {error_pct:.2f}%')

mse = mean_squared_error(y_test, y_pred)
r2 = r2_score(y_test, y_pred)

print(f'MSE: {mse}')
print(f'R^2: {r2}')
