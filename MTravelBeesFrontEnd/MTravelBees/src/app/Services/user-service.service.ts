import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../Entities/user';
import { catchError, Observable, throwError } from 'rxjs';
import { OtpValidationRequest } from '../Entities/otp-validation-request';
import { OtpValidationResponse } from '../Entities/otp-validation-response';
import { UserLoginDto } from '../Entities/user-login-dto';
import { ForgotPasswordDto } from '../Entities/forgot-password-dto';
import { ResetPassword } from '../Entities/reset-password';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

   //private apiUrl = 'http://localhost:8090';
  //private apiUrl = 'http://gateway:8090';

  private apiUrl = environment.apiUrl;
  
  constructor(private http: HttpClient) { }

  registerUser(user: User): Observable<User> {
    return this.http.post<User>(`${this.apiUrl}/auth/register`, user) .pipe(catchError(this.handleError));
  }
  registerAdminwithoutOTP(user: User): Observable<User> {
    return this.http.post<User>(`${this.apiUrl}/auth/adminRegisterwithoutOTP`, user) .pipe(catchError(this.handleError));
  }

  registerAdmin(user: User): Observable<User> {
    return this.http.post<User>(`${this.apiUrl}/auth/adminRegister`, user) .pipe(catchError(this.handleError));
  }

  validateOtp(otpValidationRequest: OtpValidationRequest): Observable<any> {
    const url = `${this.apiUrl}/validate-otp`;
    // const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post<OtpValidationResponse>(`${this.apiUrl}/auth/validate-otp`, otpValidationRequest) .pipe(catchError(this.handleError));
      
}

loginUser(user: UserLoginDto): Observable<any> {
  return this.http.post<any>(`${this.apiUrl}/auth/token`, user) .pipe(catchError(this.handleError));
}

getUserById(id: number): Observable<any> {
  let tokenStr='Bearer '+localStorage.getItem('token');
    const headers=new HttpHeaders().set('Authorization',tokenStr);
  return this.http.get(`${this.apiUrl}/auth/${id}`,{headers}) .pipe(catchError(this.handleError));
}
forgotPassword(forgotPasswordDto:ForgotPasswordDto): Observable<ForgotPasswordDto> {
  const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
  return this.http.post<ForgotPasswordDto>(`${this.apiUrl}/auth/forgotPassword`, forgotPasswordDto) .pipe(catchError(this.handleError));
}


resetPassword(resetPassword:ResetPassword): Observable<ResetPassword> {
  const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
  return this.http.patch<ResetPassword>(`${this.apiUrl}/auth/resetPassword`, resetPassword) .pipe(catchError(this.handleError));
}






// private handleError(error: any): Observable<never> {
//   // Log the error or send it to a logging service
//   console.error('An error occurred:', error); // Log to console or any logging service
  
//   // Customize the error message
//   let errorMessage = 'Something went wrong. Please try again later.';
//   if (error.error instanceof ErrorEvent) {
//     // Client-side error
//     errorMessage = `Error: ${error.error.message}`;
//   } else {
//     // Server-side error
//     errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
//   }
  
//   // Return a user-friendly error message
//   return throwError(errorMessage);
// }
private handleError(error: any) {
  // Handle the error here
  console.error('An error occurred:', error);
  return throwError(() => new Error('Something went wrong; please try again later.'));
}

}