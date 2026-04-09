# 🚦 Smart City Traffic Control
Sistema inteligente de monitoramento e controle de mobilidade urbana em tempo real.

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![Python](https://img.shields.io/badge/Python-3776AB?style=for-the-badge&logo=python&logoColor=white)
![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white)

## 🏙️ Sobre o Projeto
O **Smart Traffic Control** é uma solução completa que atua como um centro de controle de mobilidade urbana. Ao invés de semáforos com tempos estáticos, o sistema reage em **tempo real** ao volume de carros e condições climáticas, tomando decisões inteligentes para evitar congestionamentos.

O sistema combina um motor Backend robusto (capaz de cálculos geoespaciais), um simulador IoT (Hardware) e um Dashboard visual moderno, permitindo o monitoramento e o controle da cidade através de uma interface interativa.

## ✨ Funcionalidades Principais

**🧠 Inteligência do Sistema (Backend & IoT)**
- **Onda Verde Automática:** Algoritmo geoespacial que identifica cruzamentos próximos e sincroniza os semáforos para verde, desafogando vias principais.
- **Simulador de Sensores IoT:** Script em Python que consome a API do *OpenWeather* para injetar dados reais de clima e simula a contagem de veículos ao vivo.
- **Auto-População de Dados:** O banco de dados se configura sozinho com cidades (ex: São Paulo, Recife, Guarulhos) na inicialização.

**🖥️ Centro de Controle (Dashboard Frontend)**
- **Mapa Interativo (Leaflet):** Visualização ao vivo de cruzamentos com marcadores dinâmicos de status (Normal, Atenção, Congestionado).
- **Clima Dinâmico e Alertas:** Detecção em tempo real de Chuva, Risco Hídrico e Neblina, refletindo diretamente no mapa.
- **Métricas ao Vivo:** Painel com cruzamentos monitorados e alertas ativos operando via WebSocket.
- **Controle Manual Override:** Possibilidade de abrir/fechar sinais específicos diretamente pela interface web.

---

## 🛠️ Tecnologias Utilizadas

**Backend (Motor e Inteligência)**
- Java 17+ com Spring Boot
- WebSocket (STOMP) para tempo real
- PostgreSQL (Banco em Produção) / H2 Database (Banco em Memória)

**Frontend (Interface Gráfica)**
- HTML5 & JavaScript Vanilla
- CSS3 (Dark UI / Glassmorphism)
- Leaflet.js (Renderização de Mapas)

**Simulação (IoT & Dados Externos)**
- Python 3 (Requests, python-dotenv)
- API OpenWeatherMap

---

## 🚀 Como executar o projeto na sua máquina

### 1. Subindo o Backend (Cérebro)
1. Clone este repositório: `git clone https://github.com/SEU_USUARIO/SEU_REPOSITORIO.git`
2. Abra a pasta `backend` na sua IDE.
3. Se não tiver o PostgreSQL, altere o arquivo `application.properties` para usar o H2.
4. Execute `BackendApplication.java`. O servidor iniciará na porta `8080`.

### 2. Abrindo o Dashboard (Frontend)
1. Navegue até a pasta do frontend.
2. Abra o arquivo `index.html` em seu navegador.
3. O mapa carregará esperando os dados da cidade.

### 3. Iniciando a Simulação de Trânsito (Python)
1. Navegue até a pasta do simulador.
2. Instale as dependências: `pip install requests python-dotenv`
3. Execute: `python simulador.py`
4. **Mágica:** Olhe para o Dashboard! Os carros vão começar a aparecer e os semáforos vão mudar de cor sozinhos!

