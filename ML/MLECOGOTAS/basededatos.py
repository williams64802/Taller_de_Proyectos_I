import pandas as pd
import random

# Crear una lista de ubicaciones
ubicaciones = ['Chilca', 'El Tambo', 'Huancayo', 'Sapallanga']

# Crear una lista de ID de Vivienda
id_vivienda = [i for i in range(1, 201)]

# Crear datos aleatorios para el consumo de agua en cada mes (enero a octubre)
consumo_enero = [round(random.uniform(0, 50), 3) for _ in range(200)]
consumo_febrero = [round(random.uniform(0, 50), 3) for _ in range(200)]
consumo_marzo = [round(random.uniform(0, 50), 3) for _ in range(200)]
consumo_abril = [round(random.uniform(0, 50), 3) for _ in range(200)]
consumo_mayo = [round(random.uniform(0, 50), 3) for _ in range(200)]
consumo_junio = [round(random.uniform(0, 50), 3) for _ in range(200)]
consumo_julio = [round(random.uniform(0, 50), 3) for _ in range(200)]
consumo_agosto = [round(random.uniform(0, 50), 3) for _ in range(200)]
consumo_septiembre = [round(random.uniform(0, 50), 3) for _ in range(200)]
consumo_octubre = [round(random.uniform(0, 50), 3) for _ in range(200)]

num_habitantes = [random.randint(1, 10) for _ in range(200)]

tipos_vivienda = ['Casa', 'Departamento', 'Condominio']

fuentes_agua = ['Red pública', 'Pozo', 'Cisterna']

tipos_uso = ['Consumo doméstico', 'Riego', 'Industrial']

data = {
    'ID de Vivienda': id_vivienda,
    'Ubicacion': [random.choice(ubicaciones) for _ in range(200)],
    'Consumo de agua enero (m³)': consumo_enero,
    'Consumo de agua febrero (m³)': consumo_febrero,
    'Consumo de agua marzo (m³)': consumo_marzo,
    'Consumo de agua abril (m³)': consumo_abril,
    'Consumo de agua mayo (m³)': consumo_mayo,
    'Consumo de agua junio (m³)': consumo_junio,
    'Consumo de agua julio (m³)': consumo_julio,
    'Consumo de agua agosto (m³)': consumo_agosto,
    'Consumo de agua septiembre (m³)': consumo_septiembre,
    'Consumo de agua octubre (m³)': consumo_octubre,
    'Numero de habitantes en la casa': num_habitantes,
    'Tipo de vivienda': [random.choice(tipos_vivienda) for _ in range(200)],
    'Fuente de agua': [random.choice(fuentes_agua) for _ in range(200)],
    'Tipo de uso': [random.choice(tipos_uso) for _ in range(200)]
}

df = pd.DataFrame(data)

df.to_csv('base_de_datos_agua.csv', index=False)
