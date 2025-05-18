import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoggingService {

  logError(error: any): void {
    const errorMessage = this.extractErrorDetails(error);
    console.error('Logged Error:', errorMessage);
    // Optionally send error to a remote logging server
    // this.sendErrorToServer(errorMessage);
  }

  private extractErrorDetails(error: any): string {
    if (error instanceof ErrorEvent) {
      // Client-side error
      return `Error: ${error.message}`;
    } else {
      // Server-side error
      return `
        Status: ${error.status} 
        Status Text: ${error.statusText} 
        URL: ${error.url} 
        Message: ${error.message} 
        Error Response: ${JSON.stringify(error.error)}
      `;
    }
  }



}
