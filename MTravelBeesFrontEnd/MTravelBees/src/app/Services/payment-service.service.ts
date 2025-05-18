import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Payment } from '../Entities/payment';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PaymentServiceService {

  // private apiUrl = 'http://localhost:8090';
  //private apiUrl = 'http://gateway:8090';

  private apiUrl = environment.apiUrl;
  
  constructor(private http: HttpClient) { }

  addPaymentForBooking(bookingId: number, payment: Payment): Observable<any> {
    let tokenStr='Bearer '+localStorage.getItem('token');
    const headers=new HttpHeaders().set('Authorization',tokenStr);
    
    return this.http.post<any>(`${this.apiUrl}/payments/bookings/${bookingId}`, payment,{headers});
  }

  getPaymentById(id: number): Observable<any> {
    let tokenStr='Bearer '+localStorage.getItem('token');
    const headers=new HttpHeaders().set('Authorization',tokenStr);
    return this.http.get(`${this.apiUrl}/payments/${id}`,{headers});
  }
}
