package com.fincare.accmangement.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ \u0010\t\u001a\u00020\u00062\u0018\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f\u0012\u0004\u0012\u00020\r0\u000bJ\u0014\u0010\u000e\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\fJ\u0016\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/fincare/accmangement/viewmodel/AccountViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/fincare/accmangement/data/AccountRepository;", "(Lcom/fincare/accmangement/data/AccountRepository;)V", "deleteAccount", "Lkotlinx/coroutines/Job;", "account", "Lcom/fincare/accmangement/db/Account;", "getAllAccounts", "callback", "Lkotlin/Function1;", "", "", "saveAccounts", "accounts", "updateAlternateName", "actId", "", "alternateName", "app_release"})
public final class AccountViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.fincare.accmangement.data.AccountRepository repository = null;
    
    public AccountViewModel(@org.jetbrains.annotations.NotNull
    com.fincare.accmangement.data.AccountRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job saveAccounts(@org.jetbrains.annotations.NotNull
    java.util.List<com.fincare.accmangement.db.Account> accounts) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job getAllAccounts(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.util.List<com.fincare.accmangement.db.Account>, kotlin.Unit> callback) {
        return null;
    }
    
    public final void updateAlternateName(@org.jetbrains.annotations.NotNull
    java.lang.String actId, @org.jetbrains.annotations.NotNull
    java.lang.String alternateName) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job deleteAccount(@org.jetbrains.annotations.NotNull
    com.fincare.accmangement.db.Account account) {
        return null;
    }
}