import requests
import random
import time
import os
from dotenv import load_dotenv

load_dotenv() # Procura o arquivo .env e lê o que tem dentro
API_KEY = os.getenv("OPENWEATHER_TOKEN")

# config
JAVA_URL = "http://localhost:8080/api/traffic"
CIDADE = "Guarulhos" 
IDS_CRUZAMENTOS = [1, 2, 3]

def get_real_weather():
    """Consulta o clima real e traduz para as regras do nosso Java"""
    try:
        # Se a chave não for encontrada no .env avisa
        if not API_KEY or API_KEY == "API_AQUI":
            print("❌ Erro: API_KEY não encontrada no arquivo .env!")
            return "NORMAL"

        url = f"http://api.openweathermap.org/data/2.5/weather?q={CIDADE}&appid={API_KEY}&units=metric"
        response = requests.get(url)
        
        if response.status_code != 200:
            print(f"⚠️ Erro na API (Status {response.status_code}). Verifique sua chave no .env.")
            return "NORMAL"

        data = response.json()
        main_weather = data['weather'][0]['main'] 
        temp = data['main']['temp']
        
        print(f"🌍 [API] {CIDADE}: Status = {main_weather} | Temp = {temp}°C")

        # Se estiver chovendo ou com neblina, alerta o sistema
        if main_weather in ["Rain", "Drizzle", "Thunderstorm", "Mist", "Fog"]:
            return "HEAVY_RAIN"
        
        return "NORMAL"
        
    except Exception as e:
        print(f"❌ Falha crítica ao buscar clima: {e}")
        return "NORMAL"

print(f"🚀 Simulador rodando! Monitorando {CIDADE}...")
print("Pressione Ctrl+C para encerrar.\n")

while True:
    # Busca o clima real do momento
    clima_da_rua = get_real_weather()

    for cid in IDS_CRUZAMENTOS:
        # Sorteia a quantidade de carros
        carros = random.randint(0, 48)

        # Lógica de Acidente 
        if random.random() < 0.15:
            condicao_final = "ACCIDENT"
        else:
            condicao_final = clima_da_rua

        # Prepara o pacote JSON para o Java
        payload = {
            "carCount": carros,
            "condition": condicao_final
        }

        try:
            # Envia para o backend java
            res = requests.post(f"{JAVA_URL}/{cid}/update", json=payload)
            
            if res.status_code == 200:
                print(f"✅ Cruzamento {cid}: {carros} carros | Status: {condicao_final}")
            else:
                print(f"⚠️ Java respondeu com erro {res.status_code}")
                
        except Exception as e:
            print(f"❌ Erro de conexão: O Java (Spring Boot) está desligado?")

    print("-" * 40)
    # espera 10 segundos
    time.sleep(10)