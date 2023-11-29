import {Injectable} from '@angular/core';
import {HttpClientWrapper} from "./httpClientWrapper";
import {Observable} from "rxjs";
import {SetupValues} from "../model/setup/setup-values";
import {ValidateSetup} from "../model/validateSetup/validate-setup";
import {EnumData} from "../model/enumData/enumData";
import {FormGroup} from "@angular/forms";

@Injectable({
  providedIn: 'root'
})
export class RequestService {

  constructor(private http: HttpClientWrapper) {
  }

  getDefaultSetup(track: string, car: string): Observable<SetupValues> {
    return this.http.get(`/api/v1/setup/default?track=${track}&car=${car}`);
  }

  getCustomSetup(id: number): Observable<SetupValues> {
    return this.http.get(`/api/v1/setup/${id}`);
  }

  getValidator(car: string): Observable<ValidateSetup> {
    return this.http.get(`/api/v1/validatesetup/${car}`);
  }

  getEnums(): Observable<EnumData> {
    return this.http.get('/api/v1/setup/enums');
  }

  getCustomSetupsByUserId(userId: number): Observable<Array<SetupValues>> {
    return this.http.get(`/api/v1/setup/user/custom/${userId}`);
  }

  loginUser(data: FormGroup):Observable<any> {
    return this.http.postWithoutHeaders(`/api/v1/auth/authenticate`, data);
  }

  registerUser(data: FormGroup):Observable<any> {
    return this.http.postWithoutHeaders(`/api/v1/auth/register`, data);
  }

  postSetup(data: SetupValues): Observable<SetupValues> {
    return this.http.post(`/api/v1/setup`, data);
  }

  updateSetup(data: SetupValues): Observable<SetupValues> {
    return this.http.put(`/api/v1/setup`, data);
  }

}
