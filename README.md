# Sim Setup Lab

Sim Setup Lab is a full-stack web application designed to allow users to create, share, and discover car setups for the popular racing simulator game, Assetto Corsa Competizione.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
- [Configuration](#configuration)
- [Contact](#contact)

## Introduction

Sim Setup Lab is built to enhance the Assetto Corsa Competizione experience by allowing users to create and share their car setups with the community. This platform provides a space to collaborate, learn, and improve racing performance for beginners and experts of the game.

## Features

- **User Accounts:** Register and log in to access personalized features.
- **Create Setups:** Build and save car setups with detailed configuration options.
- **Browse Setups:** Discover setups shared by the community, filter by car, track, and more.

## Getting Started

### Prerequisites

Before you begin, ensure you have met the following requirements:

- **Node.js:** [Download and install Node.js](https://nodejs.org/).
- **Angular CLI:** Install the Angular CLI globally with `npm install -g @angular/cli`.
- **Java:** [Download and install Java](https://www.oracle.com/java/technologies/javase-downloads.html).
- **Spring Boot:** [Set up a Spring Boot development environment](https://spring.io/guides/gs/spring-boot/).
- **PostgreSQL:** [Install PostgreSQL](https://www.postgresql.org/download/) and create a database for the application.

### Installation

1. Clone the repository:

```bash
   git clone https://github.com/lojb/sim-setup-lab.git
   cd sim-setup-lab
```

```bash
    cd frontend
    npm install
    ng serve
```

- Configure your PostgreSQL database connection in application.properties

```bash
    cd backend
    ./mvnw spring-boot:run
```

# Usage

- Register an account or log in.
- Create, share, and discover car setups.

# Configuration

- Modify application.properties in the backend to set up your database connection and other configuration options.

- Modify enviroment variables in the backend.

# Contact

- For any questions or feedback, please contact me at balazsloj02@gmail.com.
