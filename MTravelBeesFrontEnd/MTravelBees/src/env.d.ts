// src/env.d.ts

interface Env {
    API_URL: string;
  }
  
  interface Window {
    env: Env;
  }
  