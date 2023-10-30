import pandas as pd
import matplotlib.pyplot as plt

data = pd.read_csv('base_de_datos_agua.csv')

X = data['Numero de habitantes en la casa']
y = data['Consumo de agua febrero (m³)']

plt.scatter(X, y)

plt.xlabel('Numero de habitantes en la casa')
plt.ylabel('Consumo febrero (m³)')
plt.title('Diagrama de Dispersión')

plt.show()
