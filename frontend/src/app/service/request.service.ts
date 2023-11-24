import {Injectable} from '@angular/core';
import {HttpClientWrapper} from "./httpClientWrapper";
import {Observable} from "rxjs";
import {SetupValues} from "../model/setup/setup-values";
import {ValidateSetup} from "../model/validateSetup/validate-setup";
import {EnumData} from "../model/enumData/enumData";

@Injectable({
  providedIn: 'root'
})
export class RequestService {

  constructor(private http: HttpClientWrapper) {
  }

  getDefaultSetup(track: string, car: string): Observable<SetupValues> {
    return this.http.get(`/api/v1/setup/default?track=${track}&car=${car}`);
  }

  getValidator(car: string): Observable<ValidateSetup> {
    return this.http.get(`/api/v1/validatesetup/${car}`);
  }

  getEnums(): Observable<EnumData> {
    return this.http.get('/api/v1/setup/enums');
  }

  postSetup(data: SetupValues): Observable<SetupValues> {
    return this.http.post('/api/v1/setup', data)
  }
}
