import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent }  from './app.component';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { HttpModule } from '@angular/http';
import {ReactiveFormsModule,FormBuilder} from '@angular/forms';
import {CustomerTableComponent} from './wallet-Application/customer-table/customer-table.component';
import {AddMoneyComponent} from './wallet-Application/add-money/add-money.component';
import {DeleteByIdComponent} from './wallet-Application/delete-by-id/delete-by-id.component';
import {ShowByIdComponent} from './wallet-Application/show-by-id/show-by-id.component';
import {ShowTransactionsComponent} from './wallet-Application/show-transactions/show-transactions.component';
import {TransferMoneyComponent} from './wallet-Application/transfer-money/transfer-money.component';
import {UpdateCustomerComponent} from './wallet-Application/update-customer/update-customer.component';
import {WithdrawMoneyComponent} from './wallet-Application/withdraw-money/withdraw-money.component';

import {Routes,RouterModule} from '@angular/router';;
import { LoginComponent } from './wallet-Application/login/login.component'
import {CustomerService} from './wallet-Application/customer.service'
const appRoutes:Routes = [
   {path:'',component:LoginComponent},
   {path:'showById',component:ShowByIdComponent},
   {path:'updateDetails',component:UpdateCustomerComponent},
   {path:'deleteCustomer',component:DeleteByIdComponent},
   {path:'addMoney',component:AddMoneyComponent},
   {path:'withdrawMoney',component:WithdrawMoneyComponent},
   {path:'transferMoney',component:TransferMoneyComponent},
   {path:'showTransaction',component:ShowTransactionsComponent}
]

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpClientModule,
        ReactiveFormsModule,
        HttpModule,
       
        RouterModule.forRoot(appRoutes)
    ],
    declarations: [
        AppComponent,
        CustomerTableComponent,
        AddMoneyComponent,     
        DeleteByIdComponent,
        ShowByIdComponent,
        ShowTransactionsComponent,
        TransferMoneyComponent,
        UpdateCustomerComponent,
        WithdrawMoneyComponent,
        LoginComponent      ],
    providers: [CustomerService],
    bootstrap: [AppComponent]
})

export class AppModule { }