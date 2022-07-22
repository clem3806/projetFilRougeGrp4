import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { FormationsComponent } from './composants/formations/formations.component';
import { MenuComponent } from './composants/menu/menu.component';

@NgModule({
  declarations: [
    AppComponent,
    FormationsComponent,
    MenuComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
