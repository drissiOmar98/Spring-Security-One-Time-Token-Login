<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://cdn.tailwindcss.com"></script>
    <title>Super Secret Home</title>
</head>
<body class="bg-gradient-to-br from-gray-100 via-gray-50 to-gray-100 font-sans">

<div class="min-h-screen flex flex-col">

    <!-- Header -->
    <header class="bg-white shadow-md">
        <div class="max-w-7xl mx-auto py-6 px-6 flex justify-between items-center">
            <h1 class="text-3xl font-extrabold text-gray-900 tracking-tight">Welcome</h1>
            <nav class="space-x-6">
                <a href="#" class="text-gray-600 hover:text-gray-900 transition">Home</a>
                <a href="#" class="text-gray-600 hover:text-gray-900 transition">About</a>
                <a href="#" class="text-gray-600 hover:text-gray-900 transition">Contact</a>
            </nav>
        </div>
    </header>

    <!-- Main content -->
    <main class="flex-grow max-w-4xl mx-auto py-16 px-6">
        <div class="bg-white rounded-2xl shadow-lg p-10 border border-gray-200">
            <h2 class="text-3xl font-bold mb-6 text-gray-800">🎉 Super Secret Home Page</h2>
            <p class="text-gray-600 mb-6 text-lg">
                If you are seeing this, it means you have successfully logged in and are authenticated!
            </p>
            <div class="flex space-x-4">
                <a href="#"
                   class="px-6 py-3 bg-blue-600 text-white rounded-xl font-semibold shadow hover:bg-blue-700 transition">
                    Explore
                </a>
                <a href="#"
                   class="px-6 py-3 bg-gray-200 text-gray-800 rounded-xl font-semibold shadow hover:bg-gray-300 transition">
                    Learn More
                </a>
            </div>
        </div>
    </main>

    <!-- Footer -->
    <footer class="bg-white border-t mt-auto">
        <div class="max-w-7xl mx-auto py-6 px-6 text-center text-gray-500 text-sm">
            &copy; 2025 Your Company. All rights reserved.
        </div>
    </footer>

</div>

</body>
</html>
