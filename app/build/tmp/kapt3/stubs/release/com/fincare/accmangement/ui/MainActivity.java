package com.fincare.accmangement.ui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rH\u0002J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0003J\"\u0010\u0016\u001a\u00020\u00112\u0018\u0010\u0017\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0004\u0012\u00020\u00110\u0018H\u0002J\"\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\u0012\u0010\u001e\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\u0012\u0010!\u001a\u00020\u00112\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\b\u0010$\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/fincare/accmangement/ui/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "REQUEST_CODE_ALTERNATE_NAME", "", "accountDatabase", "Lcom/fincare/accmangement/db/AccountDatabase;", "accountRepository", "Lcom/fincare/accmangement/data/AccountRepository;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "staticData", "", "Lcom/fincare/accmangement/db/Account;", "checkPermission", "", "deleteAccount", "", "account", "downloadAndOpenPDF", "pdfUrl", "", "fetchAccounts", "callback", "Lkotlin/Function1;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "openPDF", "uri", "Landroid/net/Uri;", "requestPermission", "app_release"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.fincare.accmangement.db.Account> staticData = null;
    private final int REQUEST_CODE_ALTERNATE_NAME = 200;
    private com.fincare.accmangement.db.AccountDatabase accountDatabase;
    private com.fincare.accmangement.data.AccountRepository accountRepository;
    private androidx.recyclerview.widget.RecyclerView recyclerView;
    
    public MainActivity() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final boolean checkPermission() {
        return false;
    }
    
    private final void requestPermission() {
    }
    
    @android.annotation.SuppressLint(value = {"Range"})
    private final void downloadAndOpenPDF(java.lang.String pdfUrl) {
    }
    
    private final void openPDF(android.net.Uri uri) {
    }
    
    private final void fetchAccounts(kotlin.jvm.functions.Function1<? super java.util.List<com.fincare.accmangement.db.Account>, kotlin.Unit> callback) {
    }
    
    @java.lang.Override
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable
    android.content.Intent data) {
    }
    
    private final void deleteAccount(com.fincare.accmangement.db.Account account) {
    }
}