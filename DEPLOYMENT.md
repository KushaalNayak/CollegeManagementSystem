# 🚀 Deployment Guide

## 🌐 Deploy Your College Management System for FREE

### Step 1: Deploy Backend to Railway

1. **Go to Railway:** https://railway.app
2. **Sign up** with GitHub
3. **Click "New Project"**
4. **Select "Deploy from GitHub repo"**
5. **Choose:** `KushaalNayak/CollegeManagementSystem`
6. **Select `backend` folder**
7. **Railway auto-deploys!**

#### Add Database:
1. **Click "New" → "Database" → "PostgreSQL"**
2. **Railway provides connection string automatically**

#### Get Your Backend URL:
- Railway will give you: `https://your-app.railway.app`
- Your API will be: `https://your-app.railway.app/api`

---

### Step 2: Deploy Frontend to Vercel

1. **Go to Vercel:** https://vercel.com
2. **Sign up** with GitHub
3. **Click "Import Project"**
4. **Choose:** `KushaalNayak/CollegeManagementSystem`
5. **Select `frontend` folder**
6. **Add Environment Variable:**
   - **Name:** `REACT_APP_API_URL`
   - **Value:** `https://your-backend-url.railway.app/api`
7. **Click "Deploy"**

#### Get Your Frontend URL:
- Vercel will give you: `https://your-app.vercel.app`

---

## 🎯 Final URLs

After deployment:
- **Frontend:** `https://your-app.vercel.app`
- **Backend:** `https://your-app.railway.app/api`
- **Swagger:** `https://your-app.railway.app/api/swagger-ui.html`

---

## 🆓 Why These Platforms Are FREE

| Platform | Free Tier | Features |
|----------|-----------|----------|
| **Railway** | $5 credit/month | PostgreSQL, Auto-deploy, Custom domains |
| **Vercel** | Unlimited | Auto-deploy, Custom domains, SSL |

---

## 🚀 Quick Deploy

Run this script to open deployment platforms:
```bash
deploy-complete-system.bat
```

**Your College Management System will be live on the internet for FREE!** 🌐
