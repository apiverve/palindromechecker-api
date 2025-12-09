from setuptools import setup, find_packages

setup(
    name='apiverve_palindromechecker',
    version='1.1.12',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='Palindrome Checker is a tool for checking if text is a palindrome. It supports options to ignore case, spaces, and punctuation, and finds the longest palindromic substring.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
