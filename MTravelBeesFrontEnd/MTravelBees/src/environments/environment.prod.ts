// src/environments/environment.prod.ts
export const environment = {
    production: true,
    apiUrl: 'http://localhost:8090'
    // apiUrl: 'http://gateway:8090'
     //apiUrl: 'http://13.200.254.156:8090'

      //apiUrl: 'http://host.docker.internal:8090'
       //apiUrl: (typeof window !== 'undefined' && window['env'] && window['env']['API_URL']) || 'http://localhost:8090'
  };
  